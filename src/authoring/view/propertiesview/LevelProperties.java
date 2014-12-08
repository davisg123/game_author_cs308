package authoring.view.propertiesview;

import java.util.LinkedHashMap;
import java.util.Map;

import javafx.scene.control.Button;
import authoring.view.icons.LevelIcon;

public class LevelProperties extends Properties{

	public LevelProperties(Object o) {
		initializeProperties(o);
	}

	@Override
	public void initializeProperties(Object o) {
		LevelIcon graphic = (LevelIcon) o;
		
		this.getChildren().clear();
		
		myMap.put("name", new PropertyTextField("Level: ", graphic.getName()));
		myMap.put("background image", new PropertyTextField("Background Image: ", graphic.getLevel().getBackgroundImage()));
		myMap.put("background music", new PropertyTextField("Background Music: ", graphic.getLevel().getBackgroundMusic()));
		
		myMap.put("is first level", new BooleanField("First level: ", graphic.getLevel().isStartLevel()));
		
		super.addMapToView();
		
		Button edit = new Button("Edit");
		//edit.setOnAction(event);
		this.getChildren().add(edit);
		
	}
	
	

}