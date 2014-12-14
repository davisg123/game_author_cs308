package authoring.eventhandlers;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.view.icons.IPropertiesMaker;
import authoring.view.propertiesview.PropertiesView;

/**
 * @author Kevin Li
 * @author Arjun Jain
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Safkat Islam
 */
public class IconClickHandler implements GameHandler<MouseEvent> {

	private PropertiesView myProperties;

	public IconClickHandler(PropertiesView props) {
		myProperties = props;
	}

	@Override
	public void handle(MouseEvent event) {
		IPropertiesMaker icon = (IPropertiesMaker) event.getSource();
		myProperties.displayProperties(icon);
	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_PRESSED;
	}

}
