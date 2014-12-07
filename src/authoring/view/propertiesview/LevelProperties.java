package authoring.view.propertiesview;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import authoring.view.icons.ImageBasedIcon;

public class LevelProperties extends Properties{

	public LevelProperties(Object o) {
		initializeProperties(o);
	}

	@Override
	public void initializeProperties(Object o) {
		ImageBasedIcon graphic = (ImageBasedIcon) o;
		
		this.getChildren().clear();
		
		HBox imageField = new HBox();
		imageField.getChildren().add(new Text("Level: "));
		imageField.getChildren().add(new TextField(graphic.getName()));
		this.getChildren().add(imageField);
		
		
	}

}