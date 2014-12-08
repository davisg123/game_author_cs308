package authoring.eventhandlers;

import java.io.File;

import authoring.model.collections.ImagesCollection;

public class AddImageHandler extends AddFileHandler {

	public AddImageHandler(ImagesCollection imagesCollection, File file) {
		super(file);
		myCollection = imagesCollection;
		myFileLocation = "/images/";
	}
}