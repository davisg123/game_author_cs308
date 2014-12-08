package authoring.eventhandlers;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

public class FileDragOverHandler implements GameHandler<Event> {

	@Override
	public void handle(Event arg0) {
		Dragboard db = ((DragEvent) arg0).getDragboard();
		if (db.hasFiles()) {
			((DragEvent) arg0).acceptTransferModes(TransferMode.COPY);
		} else {
			arg0.consume();
		}
	}

	@Override
	public EventType getEventType() {
		return Event.ANY;
	}

}
