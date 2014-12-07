package authoring.view.propertiesview;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import authoring.eventhandlers.GameHandler;
import authoring.view.icons.BaseIcon;
import authoring.view.icons.LevelIcon;

public class LevelProperties extends Properties{

	public LevelProperties(LevelIcon i, GameHandler ...handler) {
		initializeProperties(i);
	}

	@Override
	public void initializeProperties(BaseIcon i) {
		LevelIcon graphic = (LevelIcon) i;
		
		this.getChildren().clear();
		
		HBox imageField = new HBox();
		imageField.getChildren().add(new Text("Level: "));
		imageField.getChildren().add(new TextField(graphic.getName()));
		this.getChildren().add(imageField);
		
		
	}

}