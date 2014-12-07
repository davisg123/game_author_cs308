package authoring.eventhandlers;

import javafx.event.Event;
import javafx.event.EventType;
import authoring.model.collections.GameObjectCollection;
import authoring.view.propertiesview.PropertiesView;
import authoring.view.wizards.NameWizard;
import engine.gameObject.GameObject;

public class SaveAsNewHandler implements GameHandler<Event>{

	private GameObjectCollection myGameObjectCollection;
	private PropertiesView myProps;
	private NameWizard myWizard;
	private GameObject myNewGameObject;
	
	public SaveAsNewHandler(GameObjectCollection coll, PropertiesView props){
		myGameObjectCollection = coll;
		myProps = props;
	}
	
	@Override
	public void handle(Event arg0) {

		myNewGameObject = myProps.getEditedGameObject();
		
		myWizard = new NameWizard("Choose Name", 230, 200, event -> updateName(), myGameObjectCollection);
		
	}

	@Override
	public EventType<Event> getEventType() {
		return Event.ANY;
	}

	private void updateName(){		
		myNewGameObject.setID(myWizard.getMap().get("name").getInformation());
		myWizard.updateObjectName(myNewGameObject);
	}
	
}
