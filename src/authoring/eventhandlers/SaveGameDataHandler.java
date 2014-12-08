package authoring.eventhandlers;

import authoring.model.AuthoringModel;
import authoring.model.GameData;
import javafx.event.Event;
import javafx.event.EventType;

public class SaveGameDataHandler implements GameHandler {

	private AuthoringModel myData;
	
	public SaveGameDataHandler (AuthoringModel data){
		myData = data;
	}
	
	@Override
	public void handle(Event arg0) {
	}

	@Override
	public EventType getEventType() {
		return Event.ANY;
	}

}
