package authoring.eventhandlers;

import java.util.Map;

import javafx.event.Event;
import javafx.event.EventType;
import authoring.model.collections.GameObjectCollection;
import authoring.view.propertiesview.PropertiesView;
import authoring.view.propertiesview.PropertyTextField;
import engine.gameObject.GameObject;

public class SaveAsNewHandler implements GameHandler<Event>{

	private GameObjectCollection myGameObjectCollection;
	private PropertiesView myProps;
	
	public SaveAsNewHandler(GameObjectCollection coll, PropertiesView props){
		myGameObjectCollection = coll;
		myProps = props;
	}
	
	@Override
	public void handle(Event arg0) {

		GameObject newGameObject = myProps.getEditedGameObject();
		
		myGameObjectCollection.add(newGameObject);
	}

	@Override
	public EventType<Event> getEventType() {
		return Event.ANY;
	}

}
