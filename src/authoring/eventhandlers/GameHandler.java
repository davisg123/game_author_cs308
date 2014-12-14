package authoring.eventhandlers;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
/**
 * @author Kevin Li
 * @author Arjun Jain
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Safkat Islam
 */
public interface GameHandler<T extends Event> extends EventHandler<T>{

	@Override
	public void handle(T arg0);
	
	public EventType<T> getEventType();
	
}
