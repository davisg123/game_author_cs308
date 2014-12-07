package authoring.eventhandlers;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.view.graphicsview.ImageGraphic;
import authoring.view.propertiesview.PropertiesView;

public class ImagesClickHandler implements GameHandler<MouseEvent>{
	private PropertiesView myProperties;

	public ImagesClickHandler(PropertiesView properties) {
		myProperties = properties;
	}

	@Override
	public void handle(MouseEvent event) {
		ImageGraphic g = (ImageGraphic) event.getSource();
		myProperties.makeProperties(g);
	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_PRESSED;
	}
}
