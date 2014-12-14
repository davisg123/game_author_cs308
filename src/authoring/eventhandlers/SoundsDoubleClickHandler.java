package authoring.eventhandlers;

import java.io.File;

import javafx.event.EventType;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import authoring.view.icons.SoundIcon;
import authoring.view.propertiesview.PropertiesView;

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