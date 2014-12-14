package authoring.eventhandlers;

import authoring.model.collections.GameObjectsCollection;
import javafx.event.Event;
import javafx.event.EventType;

/**
 * @author Kevin Li
 * @author Arjun Jain
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Safkat Islam
 */
public class NewGameObjectSubmitHandler implements GameHandler<Event> {

	public GameObjectsCollection myGameObjectCollection;

	public NewGameObjectSubmitHandler(
			GameObjectsCollection myGameObjectCollection) {
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
