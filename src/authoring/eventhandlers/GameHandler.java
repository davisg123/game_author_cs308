package authoring.eventhandlers;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;

/**
 * The custom event handler hierarchy used in Authoring. Usage of event handlers
 * allow us to cut down and inclose interaction between view components and
 * view/model interactions.
 * 
 * @author Kevin Li
 * @author Arjun Jain
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Safkat Islam
 */
public interface GameHandler<T extends Event> extends EventHandler<T> {
	/**
	 * Handle that determines what the handler does.
	 */
	@Override
	public void handle(T arg0);

	public EventType<T> getEventType();

}
