package authoring.view.icons;

import engine.level.Level;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import authoring.eventhandlers.GameHandler;

public class LevelIcon extends BaseIcon {

	private static final int DEFAULT_FONT_SIZE = 20;
	private Level myLevel;
	private GameHandler[] myLevelEvents;

	public LevelIcon(String s, GameHandler[] event, Level l,
			GameHandler... levelEvents) {
		super(s, event);
		myLevel = l;
		myLevelEvents = levelEvents;
		setupGraphic();
	}

	public void setupGraphic() {
		Text text = new Text(myLabel);
		text.setFont(new Font(DEFAULT_FONT_SIZE));
		this.getChildren().add(text);
		for (GameHandler g : myOnClick) {
			this.addEventFilter(g.getEventType(), g);
		}

	}

	public Level getLevel() {
		return myLevel;
	}

	public GameHandler[] getLevelEvents() {
		return myLevelEvents;
	}

}
