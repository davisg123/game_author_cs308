package authoring.eventhandlers;

import javafx.event.EventType;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import authoring.view.icons.SoundIcon;

/**
 * @author Kevin Li
 * @author Arjun Jain
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Safkat Islam
 */
public class SoundsDoubleClickHandler implements GameHandler<MouseEvent> {

	@Override
	public void handle(MouseEvent event) {
		SoundIcon g = (SoundIcon) event.getSource();
		if (event.getButton().equals(MouseButton.PRIMARY)) {
			if (event.getClickCount() == 2) {
				g.play();
			}
		}
	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_PRESSED;

	}
}