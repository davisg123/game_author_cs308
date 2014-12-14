package authoring.eventhandlers;

import java.io.File;

import authoring.model.collections.ImagesCollection;
/**
 * @author Kevin Li
 * @author Arjun Jain
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Safkat Islam
 */
public class AddImageHandler extends AddFileHandler {

	public AddImageHandler(ImagesCollection imagesCollection, File file) {
		super(file);
		myCollection = imagesCollection;
		myFileLocation = "/images/";
	}
}