package authoring.eventhandlers;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.view.icons.GameObjectIcon;
import authoring.view.propertiesview.PropertiesView;

public class GameObjectClickHandler extends ClickHandler<GameObjectIcon>{

	public GameObjectClickHandler(PropertiesView properties) {
		super(properties);
	}
	
	@Override
	public void handle(MouseEvent event) {
		GameObjectIcon g = (GameObjectIcon) event.getSource();
		myProperties.makeProperties(g);
	}
	
}
