package authoring.eventhandlers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import authoring.model.collections.ImagesCollection;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.input.Dragboard;
import javafx.scene.input.DragEvent;

public class UploadDragDropHandler implements GameHandler {
	ImagesCollection myImagesCollection;
	File myGameFile;

	public UploadDragDropHandler(ImagesCollection imagesCollection, File file) {
		myImagesCollection = imagesCollection;
		myGameFile = file;
	}

	@Override
	public void handle(Event arg0) {
		Dragboard db = ((DragEvent) arg0).getDragboard();
		boolean success = false;
		if (db.hasFiles()) {
			success = true;

			for (File imageFile : db.getFiles()) {

				BufferedImage bi;
				try {
					bi = ImageIO.read(imageFile);
					File newImageFile = new File(myGameFile.getPath()
							+ "/images/" + imageFile.getName());
					ImageIO.write(bi, "png", newImageFile);
					myImagesCollection.add(newImageFile.getName());
				} catch (IOException e) {
					System.out.println("Bad file");
				}
			}
		}
		((DragEvent) arg0).setDropCompleted(success);
		arg0.consume();
	}

	@Override
	public EventType getEventType() {
		return Event.ANY;
	}

}
