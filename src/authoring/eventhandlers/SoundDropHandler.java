package authoring.eventhandlers;

import java.io.File;

import authoring.model.collections.SoundsCollection;

public class SoundDropHandler extends FileDropHandler {
	/**
	 * @author Kevin Li
	 * @author Arjun Jain
	 * @author Chris Bernt
	 * @author Wesley Valentine
	 * @author Safkat Islam
	 */
	public SoundDropHandler(SoundsCollection soundsCollection, File file) {
		super(file);
		myCollection = soundsCollection;
		myFileLocation = "/sounds/";

	}

}
