package authoring.eventhandlers;

import java.io.File;

import authoring.model.collections.SoundsCollection;
/**
 * @author Kevin Li
 * @author Arjun Jain
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Safkat Islam
 */
public class AddSoundHandler extends AddFileHandler {
	public AddSoundHandler(SoundsCollection soundCollection, File file) {
		super(file);
		myCollection = soundCollection;
		myFileLocation = "/sounds/";
	}
}
