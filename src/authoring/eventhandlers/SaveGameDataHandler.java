package authoring.eventhandlers;

import authoring.model.AuthoringModel;
import authoring.model.GameData;
import javafx.event.Event;
import javafx.event.EventType;

/**
 * @author Kevin Li
 * @author Arjun Jain
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Safkat Islam
 */
public class SaveGameDataHandler implements GameHandler {

	private AuthoringModel myData;

	public SaveGameDataHandler(AuthoringModel data) {
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
