package authoring.eventhandlers;

import javafx.event.Event;
import javafx.event.EventType;
import authoring.view.wizards.AddConditionIDWizard;
import authoring.view.wizards.Wizard;
import engine.gameObject.Identifier;
import engine.level.Level;
/**
 * @author Kevin Li
 * @author Arjun Jain
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Safkat Islam
 */
public class DeleteConditionFromLevelHandler implements GameHandler<Event>{

	private Level myLevel;
	private Wizard myDeleteConditionHandler;
	
	public DeleteConditionFromLevelHandler(Level l){
		myLevel = l;
	}
	
	
	@Override
	public void handle(Event arg0) {
		//add condition handler works just as well, just a text field with a submit button
		myDeleteConditionHandler = new AddConditionIDWizard("Delete Condition", 200, 200, event -> deleteCondition());
	}

	@Override
	public EventType<Event> getEventType() {
		return Event.ANY;
	}
	
	private void deleteCondition(){
		for(Identifier i : myLevel.getConditionIdentifiers()){
			if(i.getUniqueId().equals(myDeleteConditionHandler.getMap().get("ID").getInformation())){
				myLevel.getConditionIdentifiers().remove(i);
				myDeleteConditionHandler.close();
				break;
			}
		}
		myDeleteConditionHandler.close();
	}

}
