package authoring.eventhandlers;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.view.propertiesview.PropertiesView;
import authoring.view.spritesview.GameObjectGraphic;

public class GameObjectClickHandler implements GameHandler<MouseEvent>{

	private PropertiesView myProperties;
	
	public GameObjectClickHandler(PropertiesView props){
		myProperties = props;
	}
	
	@Override
	public void handle(MouseEvent event) {
		System.out.println("GAME OBJECT");
		GameObjectGraphic g = (GameObjectGraphic) event.getSource();
		myProperties.makeProperties(g.getGameObject());
		
	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_CLICKED;
	}

}
