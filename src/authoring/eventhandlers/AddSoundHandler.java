package authoring.eventhandlers;

import java.io.File;

import authoring.model.collections.SoundsCollection;

public class AddSoundHandler extends AddFileHandler {
	public AddSoundHandler(SoundsCollection soundCollection, File file) {
		super(file);
		myCollection = soundCollection;
		myFileLocation = "/sounds/";
	}
}
