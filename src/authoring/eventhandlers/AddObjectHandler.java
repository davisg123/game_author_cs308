package authoring.eventhandlers;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import authoring.model.collections.GameObjectsCollection;
import authoring.view.propertiesview.GameObjectsProperties;
import engine.gameObject.GameObject;

public class AddObjectHandler implements GameHandler<Event>{

	private GameObjectsCollection myGameObjectCollection;
	private GameObject myGameObject;
	
	public AddObjectHandler(GameObjectsCollection myGameObjectCollection){
		this.myGameObjectCollection = myGameObjectCollection;
	}
	
	@Override
	public void handle(Event arg0) {
		Stage dialog = new Stage();
		dialog.setTitle("New Game Object");
		dialog.initStyle(StageStyle.DECORATED);
		Group root = new Group();
		
		GameObjectsProperties properties = new GameObjectsProperties(new GameObject(), null);
		properties.setUpForNewObject().setOnMouseClicked(event -> createGameObject(properties, dialog));
		root.getChildren().add(properties);
		Scene scene = new Scene(root, 400, 400);
		dialog.setScene(scene);
		dialog.show();
		
	}

	@Override
	public EventType<Event> getEventType() {
		return Event.ANY;
	}
	
	public void createGameObject(GameObjectsProperties prop, Stage s){
		myGameObject = prop.edit(new GameObject());
		myGameObjectCollection.addGameObject(myGameObject);
		s.close();
	}

}
