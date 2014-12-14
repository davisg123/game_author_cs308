package authoring.view.icons;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import authoring.eventhandlers.AddConditionIDHandler;
import authoring.eventhandlers.GameHandler;
import authoring.view.propertiesview.LevelProperties;
import authoring.view.propertiesview.Properties;
import engine.level.Level;

public class LevelIcon extends TextIcon implements IPropertiesMaker{

	public static final int DEFAULT_FONT_SIZE = 20;
	private Level myLevel;
	private GameHandler[] myLevelEvents;

	public LevelIcon(String s, GameHandler[] events, Level l,
			GameHandler... levelEvents) {
		super(s, events);
		myLevel = l;
		myLevelEvents = levelEvents;
	}

	public Level getLevel() {
		return myLevel;
	}
	
	public GameHandler[] getLevelEvents(){
		return myLevelEvents;
	}

	@Override
	public Properties makeProperties() {
		return new LevelProperties(this, new AddConditionIDHandler(this.getLevel()));
	}
	

}
