package authoring.eventhandlers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import authoring.model.collections.GeneralCollection;

public abstract class FileDropHandler implements GameHandler<Event> {
	GeneralCollection myCollection;
	File myGameFile;
	String myFileLocation;

	public FileDropHandler(File file) {
		myGameFile = file;
		
	}

	@Override
	public void handle(Event arg0) {
		Dragboard db = ((DragEvent) arg0).getDragboard();
		boolean success = false;
		if (db.hasFiles()) {
			success = true;
			for (File imageFile : db.getFiles()) {
				try {
					File destFile = new File(myGameFile.getPath()
							+ myFileLocation + imageFile.getName());
					Files.copy(imageFile.toPath(), destFile.toPath());
					myCollection.add(destFile.getName());
				} catch (IOException e) {
					System.out.println("Bad File");
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
