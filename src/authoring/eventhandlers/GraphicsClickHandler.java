package authoring.eventhandlers;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.view.graphicsview.Graphic;
import authoring.view.levelview.LevelsView;
import authoring.view.propertiesview.PropertiesView;

public class GraphicsClickHandler implements GameHandler<MouseEvent>{
	private PropertiesView myProperties;
	private LevelsView myLevels;

	public GraphicsClickHandler(PropertiesView properties, LevelsView levels) {
		myProperties = properties;
		myLevels = levels;
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
