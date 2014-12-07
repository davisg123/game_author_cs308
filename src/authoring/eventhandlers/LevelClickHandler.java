package authoring.eventhandlers;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.view.icons.LevelIcon;
import authoring.view.propertiesview.PropertiesView;

public class LevelClickHandler implements GameHandler<MouseEvent>{
	
	private PropertiesView myProperties;
	
	public LevelClickHandler(PropertiesView props){
		myProperties = props;
	}
	
	@Override
	public void handle(MouseEvent event) {
		LevelIcon level = (LevelIcon) event.getSource();
		myProperties.makeProperties(level);
		
	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_PRESSED;
	}

}

