package authoring.eventhandlers;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.event.Event;
import javafx.event.EventType;
import authoring.view.wizards.ActionChoiceWizard;
import authoring.view.wizards.ConditionParameterWizard;
import authoring.view.wizards.ConditionSelectionWizard;

public class AddConditionHandler implements GameHandler<Event> {

	private static final String CONDITION_PATH_START = "engine.conditions.";
	private static final int WIZARD_WIDTH = 300;
	private static final int WIZARD_HEIGHT = 600;

	private ConditionSelectionWizard myWizard;
	private ConditionParameterWizard myCPW;
	private ActionChoiceWizard myActionChoiceWizard;

	private List<String> myInputParameters;
	private Class<?>[] myParameterTypes;

	@Override
	public void handle(Event arg0) {
		myWizard = new ConditionSelectionWizard("New Condition", WIZARD_WIDTH,
				WIZARD_HEIGHT, event -> createCondition());
	}

	@Override
	public EventType<Event> getEventType() {
		return Event.ANY;
	}

	private void createCondition() {
		String selected = myWizard.getSelectedCondition();

		try {
			Class<?> classType = Class.forName(CONDITION_PATH_START + selected);
			System.out.println(classType.toString());

			Constructor[] constructors = classType.getDeclaredConstructors();
			myParameterTypes = constructors[0].getParameterTypes();
			for (Class c : myParameterTypes){
				System.out.println(c.getDeclaredFields());
				for (Field f : c.getDeclaredFields()){
					System.out.println("fgjhfghfgh" + f.getGenericType());
				}
			}

			System.out.println(Arrays.deepToString(myParameterTypes));

			myCPW = new ConditionParameterWizard("Choose Parameters",
					WIZARD_WIDTH, WIZARD_HEIGHT, myParameterTypes, classType,
					event -> fillConditionParameters());

		} catch (ClassNotFoundException e) {
			System.out.println("Bad Class");
		}

	}

	private void fillConditionParameters() {
		myInputParameters = new ArrayList<String>();
		for (String s : myCPW.getMap().keySet()) {
			myInputParameters.add(myCPW.getMap().get(s).getInformation());
		}
		myWizard.disableSelection();
		myWizard.enableActionCreation(event -> addAction());

		myCPW.close();
	}

	private void addAction() {
		myActionChoiceWizard = new ActionChoiceWizard("Choose Action",
				WIZARD_WIDTH, WIZARD_HEIGHT, event -> createAction());

	}

	private void createAction() {
		System.out.println("heyah");
	}

	private void convertInputParameters() {
		// myInputParameters
		
	}

}
