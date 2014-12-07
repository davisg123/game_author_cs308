package authoring.eventhandlers;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.view.gameobjectsview.GameObjectGraphic;
import authoring.view.propertiesview.PropertiesView;

public class GameObjectClickHandler implements GameHandler<MouseEvent>{

	//VERY similar to image click handler, refactor
	
	private PropertiesView myProperties;
	
	public GameObjectClickHandler(PropertiesView props){
		myProperties = props;
	}
	
	@Override
	public void handle(MouseEvent event) {
		GameObjectGraphic g = (GameObjectGraphic) event.getSource();
		myProperties.makeProperties(g.getGameObject());
		
	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_PRESSED;
	}

}
