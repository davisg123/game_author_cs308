package authoring.view.propertiesview;

import authoring.view.baseclasses.ScrollView;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public abstract class Properties extends VBox{

	public Properties(ScrollView v){
		initializeProperties(v);
	}
	
	public abstract void initializeProperties(ScrollView v);

}
