package authoring.eventhandlers;

import java.util.Arrays;

import javafx.event.Event;
import javafx.event.EventType;
import authoring.view.wizards.AddConditionIDWizard;
import engine.gameObject.Identifier;
import engine.level.Level;

public class AddConditionIDHandler implements GameHandler<Event>{

	private Level myLevel;
	private AddConditionIDWizard myWizard;
	
	public AddConditionIDHandler(Level level){
		myLevel = level;
	}
	
	@Override
	public void handle(Event arg0) {
		myWizard = new AddConditionIDWizard("Add Condition", 200, 200, event -> addNewCondition());
	}

	@Override
	public EventType<Event> getEventType() {
		return Event.ANY;
	}
	
	public void addNewCondition(){
		myLevel.getConditionCollection().add(new Identifier("Condition", myWizard.getMap().get("ID").getInformation()));
		myWizard.close();
	}

}
