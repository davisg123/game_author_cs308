package authoring.eventhandlers;

import engine.level.Level;
import authoring.model.collections.GameObjectsCollection;
import authoring.view.gameobjectsview.GameObjectGraphic;
import authoring.view.levelview.LevelGraphic;
import authoring.view.levelview.LevelsView;
import authoring.view.levelview.SingleLevelView;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;

public class LevelToViewHandler implements GameHandler<MouseEvent>{

	private LevelsView myLevels;
	
	public LevelToViewHandler(LevelsView levels){
		myLevels = levels;
	}
	
	@Override
	public void handle(MouseEvent event) {
		LevelGraphic l = (LevelGraphic) event.getSource();
		SingleLevelView newLevelView = myLevels.addExistingLevel(l.getLevel(), l.getLevelEvents());
		newLevelView.setID(l.getLevel().getLevelID());
		l.getLevel().addObserver(newLevelView);
	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_CLICKED;
	}

}
