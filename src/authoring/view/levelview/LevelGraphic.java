package authoring.view.levelview;

import engine.level.Level;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import authoring.eventhandlers.GameHandler;
import authoring.view.graphicsview.Graphic;

public class LevelGraphic extends Graphic {

	private Level myLevel;
	private GameHandler[] levelEvents;
	private String myLevelName;
	
	public LevelGraphic(String s, GameHandler[] event, Level l, GameHandler ... levelEvents) {
		super(s, event);
		myLevelName = s;
		myLevel = l;
		this.levelEvents = levelEvents;
		setupGraphic();
	}

	
	public void setupGraphic() {
		Text text = new Text(myLevelName);
		text.setFont(new Font(20));
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


	@Override
	public void makeProperties() {
		// TODO Auto-generated method stub
		
	}
	
}
