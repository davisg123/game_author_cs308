package authoring.eventhandlers;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.model.collections.LevelsCollection;
import authoring.view.levelview.LevelsView;
import authoring.view.propertiesview.PropertiesView;
import engine.level.Level;

public class EditGameObjectHandler implements GameHandler<Event>{

	private LevelsView myLevelsView;
	private LevelsCollection myLevelsCol;
	private PropertiesView myPropertiesView;
	
	public EditGameObjectHandler(LevelsView lv, LevelsCollection levelsCol, PropertiesView props){
		myLevelsView = lv;
		myLevelsCol = levelsCol;
		myPropertiesView = props;
	}
	
	@Override
	public void handle(Event arg0) {
		
		System.out.println("GHFGHGFHS");
		
		String id = myLevelsView.getCurrentLevel().getID();
		for (Level level : myLevelsCol) {
			if (level.getLevelID().equals(id)) {
				
				level.removeGameObject(myPropertiesView.getCurrentGameObject());
				level.addGameObject(myPropertiesView.getEditedGameObject());
				
				
			}
		}
	}

	@Override
	public EventType<Event> getEventType() {
		return Event.ANY;
	}

}
