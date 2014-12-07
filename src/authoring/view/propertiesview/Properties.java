package authoring.view.propertiesview;

import javafx.scene.layout.VBox;
import authoring.view.graphicsview.Graphic;

public abstract class Properties extends VBox{

	public abstract void initializeProperties(Graphic g); //game object, level, sound, image...

}
