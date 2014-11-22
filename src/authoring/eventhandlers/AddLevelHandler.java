package authoring.eventhandlers;

import engine.level.Level;
import authoring.model.collections.LevelsCollection;
import authoring.view.levelview.LevelsView;
import authoring.view.levelview.SingleLevelView;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;


public class AddLevelHandler implements GameHandler<MouseEvent> {
	
	private LevelsView myLevels;
	private LevelsCollection myLevelsCollection;

	public AddLevelHandler (LevelsView levels, LevelsCollection levelsCollection){
		myLevels = levels;
		myLevelsCollection = levelsCollection;
	}
	
	@Override
	public void handle(MouseEvent arg0) {
		SingleLevelView newLevelView = myLevels.getLevelOptions().addNewLevel();
//		Level levelData = new Level();
//		myLevelsCollection.add(levelData);
//		levelData.addObserver(newLevelView);
		
		
	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_CLICKED;
	}

	

}
