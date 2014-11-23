package authoring.eventhandlers;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.model.collections.GameObjectsCollection;
import authoring.model.collections.LevelsCollection;
import authoring.view.levelview.LevelOptions;
import authoring.view.levelview.LevelsView;
import authoring.view.levelview.SingleLevelView;
import engine.gameObject.GameObject;
import engine.gameObject.components.Component;
import engine.level.Level;


public class AddLevelHandler implements GameHandler<Event> {
	
	private LevelsView myLevels;
	private LevelsCollection myLevelsCollection;

	public AddLevelHandler (LevelsCollection levelsCollection){
		myLevelsCollection = levelsCollection;
	}
	
	@Override
	public void handle(Event arg0) {
		SingleLevelView newLevelView = myLevels.getLevelOptions().addNewLevel();
		Level levelData = new Level(new GameObjectsCollection());
		myLevelsCollection.add(levelData);
		levelData.addObserver(newLevelView);
		
//		String im = "/assets/mario.png";
//		GameObject test = new GameObject(new ArrayList<Component>(), im, new Point2D.Double(), 0, 0, 0, "Mario");
//		levelData.addGameObject(test);
	}
	
	public void setLevelOptions(LevelsView l){
		myLevels = l;
	}

	@Override
	public EventType<Event> getEventType() {
		return Event.ANY;
	}

	

}
