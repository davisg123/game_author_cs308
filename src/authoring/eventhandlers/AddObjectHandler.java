package authoring.eventhandlers;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import authoring.model.collections.GameObjectsCollection;
import authoring.view.graphicsview.GameObjectGraphic;
import authoring.view.propertiesview.GameObjectProperties;
import engine.gameObject.GameObject;

public class AddObjectHandler implements GameHandler<Event>{

	private GameObjectsCollection myGameObjectCollection;
	private GameObject myGameObject;
	private static final double NEW_GAMEOBJECT_WINDOW_HEIGHT = 400;
	private static final double NEW_GAMEOBJECT_WINDOW_WIDTH = 400;
	
	public AddObjectHandler(GameObjectsCollection myGameObjectCollection){
		this.myGameObjectCollection = myGameObjectCollection;
	}
	
	@Override
	public void handle(Event arg0) {
		Stage dialog = new Stage();
		dialog.setTitle("New Game Object");
		dialog.initStyle(StageStyle.DECORATED);
		Group root = new Group();
		
		//Make this not a properties but like a new object wizard
		GameObjectProperties properties = new GameObjectProperties(new GameObjectGraphic(new GameObject(), null, null));
		properties.setUpForNewObject().setOnMouseClicked(event -> createGameObject(properties, dialog));
		root.getChildren().add(properties);
		Scene scene = new Scene(root, NEW_GAMEOBJECT_WINDOW_WIDTH, NEW_GAMEOBJECT_WINDOW_HEIGHT);
		dialog.setScene(scene);
		dialog.show();
		
	}

	@Override
	public EventType<Event> getEventType() {
		return Event.ANY;
	}
	
	public void createGameObject(GameObjectProperties prop, Stage s){
		myGameObject = prop.edit(new GameObject());
		myGameObjectCollection.add(myGameObject);
		s.close();
	}

}
