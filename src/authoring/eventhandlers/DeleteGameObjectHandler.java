package authoring.eventhandlers;

import javafx.event.Event;
import javafx.event.EventType;
import authoring.model.collections.LevelsCollection;
import authoring.view.levelview.LevelsView;
import authoring.view.propertiesview.PropertiesView;
import engine.level.Level;

public class DeleteGameObjectHandler implements GameHandler<Event>{

	private LevelsView myLevelsView;
	private LevelsCollection myLevelsCol;
	private PropertiesView myPropertiesView;
	
	public DeleteGameObjectHandler(LevelsView lv, LevelsCollection levelsCol, PropertiesView props){
		myLevelsView = lv;
		myLevelsCol = levelsCol;
		myPropertiesView = props;
	}
	
	
	@Override
	public void handle(Event arg0) {
		String id = myLevelsView.getCurrentLevel().getID();
		for (Level level : myLevelsCol) {
			if (level.getIdentifier().getUniqueId().equals(id)) {
				
					level.removeGameObject(myPropertiesView.getCurrentGameObject());

			}
		}
	}

	@Override
	public EventType<Event> getEventType() {
		return Event.ANY;
	}

}
