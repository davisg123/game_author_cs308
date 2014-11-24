package authoring.eventhandlers;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import authoring.view.propertiesview.GameObjectsProperties;
import engine.gameObject.GameObject;

public class AddObjectHandler implements GameHandler<Event>{

	@Override
	public void handle(Event arg0) {
		Stage dialog = new Stage();
		dialog.setTitle("New Game Object");
		dialog.initStyle(StageStyle.DECORATED);
		Group root = new Group();
		
		GameObjectsProperties properties = new GameObjectsProperties(new GameObject(), null);
		properties.setUpForNewObject();
		root.getChildren().add(properties);
		
		Scene scene = new Scene(root, 400, 400);
		dialog.setScene(scene);
		dialog.show();
		
	}

	@Override
	public EventType<Event> getEventType() {
		return Event.ANY;
	}

}
