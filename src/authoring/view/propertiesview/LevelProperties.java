package authoring.view.propertiesview;

import authoring.view.graphicsview.Graphic;
import authoring.view.graphicsview.LevelGraphic;

public class LevelProperties extends Properties{

	public LevelProperties(LevelGraphic g){
		initializeProperties(g);
	}
	
	@Override
	public void initializeProperties(Graphic g) {
		LevelGraphic levelGraphic = (LevelGraphic) g;
		
		this.getChildren().clear();
		
		
		this.getChildren().add(new PropertyTextField("Name: ", levelGraphic.getName()));
		
	}

}
