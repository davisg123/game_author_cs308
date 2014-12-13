package authoring.eventhandlers;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.view.icons.GameObjectIcon;
import authoring.view.propertiesview.PropertiesView;

public class GameObjectClickHandler implements GameHandler<MouseEvent>{

	private PropertiesView myProperties;
	
	public GameObjectClickHandler(PropertiesView props){
		myProperties = props;
	}
	
	@Override
	public void handle(MouseEvent event) {
		GameObjectIcon g = (GameObjectIcon) event.getSource();
		myProperties.makeProperties(g.getGameObject());
		
	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_PRESSED;
	}

}
