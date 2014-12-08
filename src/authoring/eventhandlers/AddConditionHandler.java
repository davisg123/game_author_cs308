package authoring.eventhandlers;

import javafx.event.Event;
import javafx.event.EventType;
import authoring.view.wizards.ConditionWizard;
import authoring.view.wizards.Wizard;

public class AddConditionHandler implements GameHandler<Event> {

	@Override
	public void handle(Event arg0) {
		Wizard wizard = new ConditionWizard("New Condition", 300, 600, event -> createCondition());
		
		
	}

	@Override
	public EventType<Event> getEventType() {
		// TODO Auto-generated method stub
		return Event.ANY;
	}
	
	public void createCondition(){
		
	}

}
