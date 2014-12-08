package authoring.eventhandlers;

import java.lang.reflect.Constructor;
import java.util.Arrays;

import javafx.event.Event;
import javafx.event.EventType;
import authoring.view.wizards.ConditionParameterWizard;
import authoring.view.wizards.ConditionSelectionWizard;
import engine.conditions.Condition;

public class AddConditionHandler implements GameHandler<Event> {
	
	private static final String CONDITION_PATH_START = "engine.conditions.";
	private static final int WIZARD_WIDTH = 300;
	private static final int WIZARD_HEIGHT = 600;
	
	private ConditionSelectionWizard myWizard;
	private ConditionParameterWizard myCPW;
	
	@Override
	public void handle(Event arg0) {
		myWizard = new ConditionSelectionWizard("New Condition", WIZARD_WIDTH, WIZARD_HEIGHT, event -> createCondition());
		
		
	}

	@Override
	public EventType<Event> getEventType() {
		return Event.ANY;
	}
	
	private void createCondition(){
		String selected = myWizard.getSelectedCondition();
		
		try {
			Class<?> classType = Class.forName(CONDITION_PATH_START + selected);
			System.out.println(classType.toString());
			
			Constructor[] constructors = classType.getDeclaredConstructors();
			Class<?>[] parameterTypes = constructors[0].getParameterTypes();
			
			System.out.println(Arrays.deepToString(parameterTypes));

			myWizard.close();
			myCPW = new ConditionParameterWizard("Choose Parameters", WIZARD_WIDTH, WIZARD_HEIGHT, parameterTypes, classType, event -> fillConditionParameters());			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Bad Class");
		}
		
	}
	
	private void fillConditionParameters(){
		System.out.println("Got here");
		
	}

}
