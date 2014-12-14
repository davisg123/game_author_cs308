package authoring.eventhandlers;

import javafx.event.Event;
import javafx.event.EventType;
import authoring.model.collections.ConditionsCollection;
import authoring.view.wizards.AddConditionIDWizard;
import authoring.view.wizards.Wizard;

public class DeleteConditionHandler implements GameHandler<Event>{

	private ConditionsCollection myConditionsCollection;
	private Wizard myDeleteConditionHandler;
	
	public DeleteConditionHandler(ConditionsCollection collection){
		myConditionsCollection = collection;
	}
	
	@Override
	public void handle(Event arg0) {

		myDeleteConditionHandler = new AddConditionIDWizard("Delete Condition", 200, 200, event -> deleteCondition());

	}

	@Override
	public EventType<Event> getEventType() {
		return Event.ANY;
	}
	
	private void deleteCondition(){
		myConditionsCollection.removeByID(myDeleteConditionHandler.getMap().get("ID").getInformation());
		myDeleteConditionHandler.close();
	}

}
