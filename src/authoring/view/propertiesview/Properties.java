package authoring.view.propertiesview;

import javafx.scene.layout.VBox;

public abstract class Properties extends VBox{

	public Properties(Object o){ //game object, level, sound, image...
		initializeProperties(o);
	}
	
	public abstract void initializeProperties(Object o);

}
