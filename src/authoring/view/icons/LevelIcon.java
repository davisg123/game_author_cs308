package authoring.view.icons;

import authoring.eventhandlers.AddConditionIDHandler;
import authoring.eventhandlers.DeleteConditionFromLevelHandler;
import authoring.eventhandlers.GameHandler;
import authoring.view.propertiesview.LevelProperties;
import authoring.view.propertiesview.Properties;
import engine.level.Level;

/**
 * @author Kevin Li
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Arjun Jain
 */
public class LevelIcon extends TextIcon implements IPropertiesMaker {

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

	public GameHandler[] getLevelEvents() {
		return myLevelEvents;
	}

	@Override
	public Properties makeProperties() {
		return new LevelProperties(this, new AddConditionIDHandler(
				this.getLevel()), new DeleteConditionFromLevelHandler(
				this.getLevel()));
	}

}
