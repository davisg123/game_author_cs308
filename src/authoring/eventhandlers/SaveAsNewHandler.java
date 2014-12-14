package authoring.eventhandlers;

import javafx.event.Event;
import javafx.event.EventType;
import authoring.model.collections.GameObjectsCollection;
import authoring.view.propertiesview.PropertiesView;
import authoring.view.wizards.GameObjectTypeWizard;
import authoring.view.wizards.NameWizard;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import errorsAndExceptions.ErrorPopUp;

public class SaveAsNewHandler implements GameHandler<Event>{

	private GameObjectsCollection myGameObjectCollection;
	private PropertiesView myProps;
	private NameWizard myWizard;
	private GameObject myNewGameObject;
	
	public SaveAsNewHandler(GameObjectsCollection coll, PropertiesView props){
		myGameObjectCollection = coll;
		myProps = props;
	}
	
	@Override
	public void handle(Event arg0) {

		myNewGameObject = myProps.getEditedGameObject();
		
		myWizard = new GameObjectTypeWizard("Choose Type ID", 230, 200, event -> updateName(), myGameObjectCollection);
		
	}

	@Override
	public EventType<Event> getEventType() {
		return Event.ANY;
	}

	private void updateName(){		
		String tryID = myWizard.getMap().get("name").getInformation();
		if(!myWizard.isDuplicated(tryID)){
			myNewGameObject.setIdentifier(new Identifier(tryID, "Template"));
			myGameObjectCollection.add(myNewGameObject);
		}
		else{
			ErrorPopUp epu = new ErrorPopUp();
			epu.display("Need to enter unique type", false);
		}
		myWizard.close();
	}
	
}
