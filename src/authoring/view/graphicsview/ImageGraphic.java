package authoring.view.graphicsview;

import java.io.File;

import authoring.eventhandlers.GameHandler;
import authoring.view.propertiesview.ImageProperties;
import authoring.view.propertiesview.Properties;

public class ImageGraphic extends Graphic{

	public ImageGraphic(String name, File location, GameHandler[] event) {
		super(name, location, event);
		this.addLabel();
	}

	public void changeDimensions(double width){
		//automatically calculates height
		myImageView.setPreserveRatio(true);
		myImageView.setFitWidth(width);
		myImageView.setRotate(0);
	}
	
	
	@Override
	public Properties makeProperties() {
		return new ImageProperties(this);
		// TODO Auto-generated method stub
		
	}


	
}
