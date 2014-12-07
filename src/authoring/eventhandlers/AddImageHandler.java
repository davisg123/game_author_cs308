package authoring.eventhandlers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;

import authoring.model.collections.ImagesCollection;

public class AddImageHandler implements GameHandler<Event> {

	ImagesCollection myImagesCollection;
	File myGameFile;
	FileChooser myFileChooser;

	public AddImageHandler(ImagesCollection imagesCollection, File file) {
		myImagesCollection = imagesCollection;
		myFileChooser = new FileChooser();
		myGameFile = file;
	}

	@Override
	public void handle(Event arg0) {
		File imageFile = myFileChooser.showOpenDialog(new Stage());
		if (imageFile != null) {
			try {
				BufferedImage bi = ImageIO.read(imageFile);
				File newImageFile = new File(myGameFile.getPath() + "/images/"
						+ imageFile.getName());
				ImageIO.write(bi, "png", newImageFile);
				//System.out.println(newImageFile.getPath());
				myImagesCollection.add(newImageFile.getName());
			} catch (IOException e) {
				System.out.println("Bad File");
			}
		}

	}

	@Override
	public EventType<Event> getEventType() {
		return Event.ANY;
	}
}