package authoring.view.levelview;

import engine.level.Level;
import javafx.scene.text.Text;
import authoring.eventhandlers.GameHandler;
import authoring.view.graphicsview.Graphic;

public class LevelGraphic extends Graphic {

	private Level myLevel;
	private GameHandler[] levelEvents;
	
	public LevelGraphic(String s, GameHandler[] event, Level l, GameHandler ... levelEvents) {
		super(s, event);
		myLevel = l;
		this.levelEvents = levelEvents;
		//System.out.println(this.levelEvents.length);
	}

	@Override
	public void makeGraphic() {
		Text text = new Text(myName);
		this.getChildren().add(text);
		for (GameHandler g : myOnClick) {
			this.addEventFilter(g.getEventType(), g);
		}

	}

	public Level getLevel(){
		return myLevel;
	}
	
	public GameHandler[] getLevelEvents(){
		return levelEvents;
	}
	
}
