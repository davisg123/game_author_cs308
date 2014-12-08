package authoring.eventhandlers;

import java.lang.reflect.Constructor;
import java.util.Arrays;

import javafx.event.Event;
import javafx.event.EventType;
import authoring.view.wizards.ConditionWizard;

public class AddConditionHandler implements GameHandler<Event> {
	
	private static final String CONDITION_PATH_START = "engine.conditions.";
	private ConditionWizard myWizard;
	
	@Override
	public void handle(Event arg0) {
		myWizard = new ConditionWizard("New Condition", 300, 600, event -> createCondition());
		
		
	}

	@Override
	public EventType<Event> getEventType() {
		return Event.ANY;
	}
	
	public void createCondition(){
		String selected = myWizard.getSelectedCondition();
		
		try {
			Class c = Class.forName(CONDITION_PATH_START + selected);
			System.out.println(c.toString());
			
			Constructor[] constructors = c.getDeclaredConstructors();
			System.out.println(Arrays.deepToString(constructors[0].getParameterTypes()));
			
		} catch (ClassNotFoundException e) {
			System.out.println("Bad Class");
		}
		
	}

}
