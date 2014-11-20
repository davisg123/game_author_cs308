package authoring.view.propertiesview;

import javafx.scene.layout.VBox;
import authoring.view.baseclasses.ScrollView;
import authoring.view.graphicsview.Graphic;

public abstract class Properties extends VBox{

	public Properties(Graphic g){
		initializeProperties(g);
	}
	
	public abstract void initializeProperties(Graphic g);

}
