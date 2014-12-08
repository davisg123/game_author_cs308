package authoring.view.icons;

import java.io.File;

import authoring.eventhandlers.GameHandler;

/**
 * Class that is part of the Graphic hierarchy. Graphic that represents images
 * the user uploads.
 * 
 * @author Kevin Li
 *
 */

public class ImageIcon extends ImageBasedIcon {

	public ImageIcon(String name, File location, GameHandler[] event) {
		super(name, location, event);
		scaleDimensions();
		this.addLabel();
	}

	/**
	 * Method that scales the dimensions of the image uploaded so that it
	 * preserves its dimensions.
	 */
	public void scaleDimensions() {
		// automatically calculates height
		myImageView.setPreserveRatio(true);
		myImageView.setFitWidth(myWidth);
		myHeight = myImageView.getFitHeight();
		myImageView.setRotate(0);
	}

}
