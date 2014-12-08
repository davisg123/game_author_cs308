package authoring.eventhandlers;

import java.io.File;

import javafx.event.EventType;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import authoring.view.icons.SoundIcon;
import authoring.view.propertiesview.PropertiesView;

public class SoundsClickHandler implements GameHandler<MouseEvent> {
	private PropertiesView myProperties;
	private File myGameLocation;
	private Boolean myPlaying;

	public SoundsClickHandler(PropertiesView properties, File gameLoc) {
		myProperties = properties;
		myGameLocation = gameLoc;
		myPlaying = false;
	}

	@Override
	public void handle(MouseEvent event) {
		SoundIcon g = (SoundIcon) event.getSource();
		myProperties.makeProperties(g);
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