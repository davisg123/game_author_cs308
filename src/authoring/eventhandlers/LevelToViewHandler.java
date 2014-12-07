package authoring.eventhandlers;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.view.graphicsview.LevelGraphic;
import authoring.view.levelview.LevelsView;
import authoring.view.levelview.SingleLevelView;
import authoring.view.propertiesview.PropertiesView;

public class LevelToViewHandler implements GameHandler<MouseEvent>{

	private LevelsView myLevels;
	private PropertiesView myProperties;
	
	public LevelToViewHandler(LevelsView levels, PropertiesView props){
		myLevels = levels;
		myProperties = props;
	}
	
	@Override
	public void handle(MouseEvent event) {
		LevelGraphic l = (LevelGraphic) event.getSource();
		SingleLevelView newLevelView = myLevels.addExistingLevel(l.getLevel(), l.getLevelEvents());
		newLevelView.setID(l.getLevel().getLevelID());
		l.getLevel().addObserver(newLevelView);
		
		myProperties.displayProperties(l);
	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_CLICKED;
	}

}
