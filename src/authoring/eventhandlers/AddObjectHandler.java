package authoring.eventhandlers;

import java.util.Map;

import javafx.event.Event;
import javafx.event.EventType;
import authoring.model.collections.GameObjectsCollection;
import authoring.view.propertiesview.PropertyTextField;
import authoring.view.wizards.GameObjectTypeWizard;
import authoring.view.wizards.GameObjectWizard;
import authoring.view.wizards.NameWizard;
import authoring.view.wizards.Wizard;
import engine.gameObject.GameObject;
import engine.gameObject.components.PhysicsBody;
import engine.physics.Velocity;
import errorsAndExceptions.ErrorPopUp;

public class AddObjectHandler implements GameHandler<Event> {

	private GameObjectsCollection myGameObjectCollection;
	private static final double NEW_GAMEOBJECT_WINDOW_HEIGHT = 400;
	private static final double NEW_GAMEOBJECT_WINDOW_WIDTH = 400;
	private Wizard myWizard;
	private NameWizard myNameWizard;
	private GameObject myNewGameObject;

	public AddObjectHandler(GameObjectsCollection myGameObjectCollection) {
		this.myGameObjectCollection = myGameObjectCollection;
	}

	@Override
	public void handle(Event arg0) {

		myWizard = new GameObjectWizard("New Game Object", NEW_GAMEOBJECT_WINDOW_WIDTH, NEW_GAMEOBJECT_WINDOW_HEIGHT,
				event -> createGameObject());

	}

	@Override
	public EventType<Event> getEventType() {
		return Event.ANY;
	}

	public void createGameObject() {
		Map<String, PropertyTextField> map = myWizard.getMap();

		myNewGameObject = new GameObject(null, map.get("image")
				.getInformation(), 0, 0, Double.parseDouble(map.get("height")
				.getInformation()), Double.parseDouble(map.get("width")
				.getInformation()), 0, "");
		
		
		
		PhysicsBody p = new PhysicsBody(Double.parseDouble(map.get("width")
				.getInformation()),Double.parseDouble(map.get("height")
				.getInformation()));
		p.setVelocity(new Velocity(Double.parseDouble(map.get("initXV").getInformation()), Double.parseDouble(map.get("initYV").getInformation())));
		
		myNewGameObject.setPhysicsBody(p);
		myWizard.close();
		
		myNameWizard = new GameObjectTypeWizard("Choose Type ID", 230, 200, event -> updateName(), myGameObjectCollection);
		
	}
	
	public void updateName(){
		String tryID = myNameWizard.getMap().get("name").getInformation();
		if(!myNameWizard.isDuplicated(tryID)){
			myNewGameObject.getIdentifier().setType((myNameWizard.getMap().get("name").getInformation()));
			myGameObjectCollection.add(myNewGameObject);
		}
		else{
			ErrorPopUp epu = new ErrorPopUp();
			epu.display("Need to enter unique type", false);
		}
		myNameWizard.close();
	}
}