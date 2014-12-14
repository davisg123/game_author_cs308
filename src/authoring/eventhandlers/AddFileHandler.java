package authoring.eventhandlers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import errorsAndExceptions.ErrorPopUp;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import authoring.model.collections.GeneralCollection;

public abstract class AddFileHandler implements GameHandler<Event> {
	protected GeneralCollection myCollection;
	protected File myGameFile;
	protected FileChooser myFileChooser;
	protected String myFileLocation;

	public AddFileHandler(File file) {
		myGameFile = file;
		myFileChooser = new FileChooser();

	}

	@Override
	public void handle(Event arg0) {
		File sourceFile = myFileChooser.showOpenDialog(new Stage());
		if (sourceFile != null) {
			/*
			 * try { BufferedImage bi = ImageIO.read(imageFile); File
			 * newImageFile = new File(myGameFile.getPath() + "/images/" +
			 * imageFile.getName()); ImageIO.write(bi, "png", newImageFile);
			 * System.out.println(newImageFile.getPath());
			 * myImagesCollection.add(newImageFile.getName()); } catch
			 * (IOException e) { System.out.println("Bad File"); } }
			 */
			try {
				File destFile = new File(myGameFile.getPath() + myFileLocation
						+ sourceFile.getName());
				Files.copy(sourceFile.toPath(), destFile.toPath());
				myCollection.add(destFile.getName());
			} catch (IOException e) {
				ErrorPopUp epu = new ErrorPopUp(e);
				epu.display("Bad File", false);
			}
		}
	}

	@Override
	public EventType<Event> getEventType() {
		// TODO Auto-generated method stub
		return Event.ANY;
	}

}
