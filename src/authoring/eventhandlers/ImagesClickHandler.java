package authoring.eventhandlers;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.view.graphicsview.Graphic;
import authoring.view.levelview.LevelsView;
import authoring.view.propertiesview.PropertiesView;

public class ImagesClickHandler implements GameHandler<MouseEvent>{
	private PropertiesView myProperties;

	public ImagesClickHandler(PropertiesView properties) {
		myProperties = properties;
	}

	@Override
	public void handle(MouseEvent event) {
		Graphic g = (Graphic) event.getSource();
		myProperties.makeProperties(g);
	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_PRESSED;
	}
}
