package authoring.eventhandlers;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.view.icons.IPropertiesMaker;
import authoring.view.propertiesview.PropertiesView;

public class IconClickHandler implements GameHandler<MouseEvent>{

private PropertiesView myProperties;
	
	public IconClickHandler(PropertiesView props){
		myProperties = props;
	}

	@Override
	public void handle(MouseEvent event) {
		IPropertiesMaker icon = (IPropertiesMaker) event.getSource();
		myProperties.makeProperties(icon);
	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_PRESSED;
	}
	
}
