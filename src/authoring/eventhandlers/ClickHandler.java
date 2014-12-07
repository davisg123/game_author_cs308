package authoring.eventhandlers;

import authoring.view.icons.ImageIcon;
import authoring.view.propertiesview.PropertiesView;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;

public abstract class ClickHandler<T> implements GameHandler<MouseEvent>{

	protected PropertiesView myProperties;

	public ClickHandler(PropertiesView properties) {
		myProperties = properties;
	}

	@Override
	public void handle(MouseEvent event) {
		T g = (T) event.getSource();
		myProperties.makeProperties(g);
	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_PRESSED;
	}

}
