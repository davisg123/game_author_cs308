package authoring.eventhandlers;

import java.io.File;

import authoring.model.collections.ImagesCollection;

public class ImageDropHandler extends FileDropHandler {

	public ImageDropHandler(ImagesCollection imagesCollection, File file) {
		super(file);
		myCollection = imagesCollection;
		myFileLocation = "/images/";
	}

}
