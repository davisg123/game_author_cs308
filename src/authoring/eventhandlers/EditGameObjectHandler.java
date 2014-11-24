package authoring.eventhandlers;

import javafx.event.Event;
import javafx.event.EventType;
import authoring.model.collections.LevelsCollection;
import authoring.view.levelview.LevelsView;
import authoring.view.propertiesview.PropertiesView;
import engine.gameObject.GameObject;
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
		
		String id = myLevelsView.getCurrentLevel().getID();
		for (Level level : myLevelsCol) {
			if (level.getLevelID().equals(id)) {
				
					if(level.removeGameObject(myPropertiesView.getCurrentGameObject())){
						GameObject editedOne = myPropertiesView.getEditedGameObject(); 
						level.addGameObject(editedOne);
						myPropertiesView.makeProperties(editedOne);
					}
					
				//System.out.println(level.getGameObjectsCollection());
			}
		}
	}

	@Override
	public EventType<Event> getEventType() {
		return Event.ANY;
	}

}
