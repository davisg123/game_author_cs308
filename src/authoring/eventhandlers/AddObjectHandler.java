package authoring.eventhandlers;

import static authoring.view.levelview.SingleLevelView.OBJECT_X_OFFSET;
import static authoring.view.levelview.SingleLevelView.OBJECT_Y_OFFSET;

import java.util.Map;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.stage.Stage;
import authoring.model.collections.GameObjectsCollection;
import authoring.view.propertiesview.GameObjectProperties;
import authoring.view.propertiesview.PropertyTextField;
import authoring.view.wizardview.GameObjectWizard;
import authoring.view.wizardview.Wizard;
import engine.gameObject.GameObject;

public class AddObjectHandler implements GameHandler<Event> {

	private GameObjectsCollection myGameObjectCollection;
	private static final double NEW_GAMEOBJECT_WINDOW_HEIGHT = 400;
	private static final double NEW_GAMEOBJECT_WINDOW_WIDTH = 400;
	private Wizard myWizard;

	public AddObjectHandler(GameObjectsCollection myGameObjectCollection) {
		this.myGameObjectCollection = myGameObjectCollection;
	}

	@Override
	public void handle(Event arg0) {

		myWizard = new GameObjectWizard("New Game Object", NEW_GAMEOBJECT_WINDOW_WIDTH, NEW_GAMEOBJECT_WINDOW_HEIGHT,
				event -> createGameObject());

		// Stage dialog = new Stage();
		// dialog.setTitle("New Game Object");
		// dialog.initStyle(StageStyle.DECORATED);
		// Group root = new Group();
		//
		// //Make this not a properties but like a new object wizard
		// GameObjectProperties properties = new GameObjectProperties(new
		// GameObjectGraphic(new GameObject(), null, null));
		// properties.setUpForNewObject().setOnMouseClicked(event ->
		// createGameObject(properties, dialog));
		// root.getChildren().add(properties);
		// Scene scene = new Scene(root, NEW_GAMEOBJECT_WINDOW_WIDTH,
		// NEW_GAMEOBJECT_WINDOW_HEIGHT);
		// dialog.setScene(scene);
		// dialog.show();

	}

	@Override
	public EventType<Event> getEventType() {
		return Event.ANY;
	}

	public void createGameObject() {
		Map<String, PropertyTextField> map = myWizard.getMap();

		GameObject newGameObject = new GameObject(null, map.get("image")
				.getInformation(), 0, 0, Double.parseDouble(map.get("height")
				.getInformation()), Double.parseDouble(map.get("width")
				.getInformation()), 0, map.get("name").getInformation());
		
		myGameObjectCollection.add(newGameObject);
		myWizard.close();
	}
}
