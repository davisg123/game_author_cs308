package authoring.eventhandlers;

import java.io.File;

import authoring.model.collections.SoundsCollection;

public class SoundDropHandler extends FileDropHandler {

	public SoundDropHandler(SoundsCollection soundsCollection, File file) {
		super(file);
		myCollection = soundsCollection;
		myFileLocation = "/sounds/";

	}

}
