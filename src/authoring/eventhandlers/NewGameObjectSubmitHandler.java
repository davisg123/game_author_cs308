package authoring.eventhandlers;

import authoring.model.collections.GameObjectCollection;
import javafx.event.Event;
import javafx.event.EventType;

public class NewGameObjectSubmitHandler implements GameHandler<Event>{

	public GameObjectCollection myGameObjectCollection;
	
	
	public NewGameObjectSubmitHandler(GameObjectCollection myGameObjectCollection){
		this.myGameObjectCollection = myGameObjectCollection;
	}
	
	
	@Override
	public void handle(Event arg0) {
		
		
	}

	@Override
	public EventType getEventType() {
		return Event.ANY;
	}

}
