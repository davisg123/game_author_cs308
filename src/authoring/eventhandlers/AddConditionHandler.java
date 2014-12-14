package authoring.eventhandlers;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javafx.event.Event;
import javafx.event.EventType;
import authoring.model.collections.ConditionsCollection;
import authoring.view.wizards.ActionChoiceWizard;
import authoring.view.wizards.ConditionParameterWizard;
import authoring.view.wizards.ConditionSelectionWizard;
import engine.actions.Action;
import engine.conditions.Condition;
import engine.gameObject.Identifier;
import errorsAndExceptions.ErrorPopUp;

/**
 * @author Kevin Li
 * @author Arjun Jain
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Safkat Islam
 */
public class AddConditionHandler implements GameHandler<Event> {

	private static final String CONDITION_PATH_START = "engine.conditions.";
	private static final int WIZARD_WIDTH = 300;
	private static final int WIZARD_HEIGHT = 600;

	private ConditionSelectionWizard mySelectionWizard;
	private ConditionParameterWizard myCPW;
	private ActionChoiceWizard myActionChoiceWizard;

	private List<String> myInputParameters;
	private Map<String, String> displayMap;
	private Parameter[] myParameterTypes;
	private Class<?> classType;
	private Constructor myConstructor;

	private ConditionsCollection myConditionsCollection;

	public AddConditionHandler(ConditionsCollection conditions) {
		myConditionsCollection = conditions;
	}

	@Override
	public void handle(Event arg0) {
		mySelectionWizard = new ConditionSelectionWizard("New Condition",
				WIZARD_WIDTH, WIZARD_HEIGHT, event -> createCondition());
	}

	@Override
	public EventType<Event> getEventType() {
		return Event.ANY;
	}

	private void createCondition() {
		String selected = mySelectionWizard.getSelectedCondition();

		try {
			classType = Class.forName(CONDITION_PATH_START + selected);

			Constructor[] constructors = classType.getDeclaredConstructors();
			myConstructor = constructors[0];
			myParameterTypes = constructors[0].getParameters();

			for (Parameter p : myParameterTypes) {
				// System.out.println(p.getParameterizedType());
			}

			// System.out.println(Arrays.deepToString(myParameterTypes));

			myCPW = new ConditionParameterWizard("Choose Parameters",
					WIZARD_WIDTH, WIZARD_HEIGHT, myParameterTypes, classType,
					event -> fillConditionParameters());

		} catch (ClassNotFoundException e) {
			ErrorPopUp epu = new ErrorPopUp(e);
			epu.display("Bad Class", false);
		}

	}

	private void fillConditionParameters() {
		//System.out.println("filling conditions");
		myInputParameters = new ArrayList<String>();
		displayMap = new LinkedHashMap<String, String>();
		for (String s : myCPW.getMap().keySet()) {
			myInputParameters.add(myCPW.getMap().get(s).getInformation());
			displayMap.put(s, myCPW.getMap().get(s).getInformation());
		}
		mySelectionWizard.disableSelection();
		// myWizard.enableActionCreation(event -> addAction());
		mySelectionWizard.enableFinalize(event -> finishCondition());
		myCPW.close();
	}

	// private void addAction() {
	// myActionChoiceWizard = new ActionChoiceWizard("Choose Action",
	// WIZARD_WIDTH, WIZARD_HEIGHT, event -> createAction());
	//
	// }
	//
	// private void createAction() {
	// System.out.println("heyah");
	// }

	private List<Object> convertInputParameters() {
		List<Object> inputs = new ArrayList<Object>();
		inputs.add(new ArrayList<Action>());
		for (int i = 0; i < myInputParameters.size(); i++) {
			Type t = myParameterTypes[i + 1].getParameterizedType();
			if (t.toString().contains("List")) {
				String[] splitType = t.toString().split("\\<");
				String type = splitType[splitType.length - 1].replace(">", "");
				List<Object> innerList = new ArrayList<Object>();
				try {
					Class<?> c = Class.forName(type);
					if (t.toString().contains("String")) {
						for (String s : myInputParameters.get(i).split("\\;")) {
							innerList.add(s);
						}
					} else {
						Method parseMethod = c.getMethod("valueOf",
								new Class[] { String.class });
						for (String s : myInputParameters.get(i).split("\\;")) {
							innerList.add(parseMethod.invoke(c, s));
						}
					}
				} catch (ClassNotFoundException | NoSuchMethodException
						| InvocationTargetException | IllegalAccessException e) {
					ErrorPopUp epu = new ErrorPopUp(e);
					epu.display("Bad Class", false);
				}
				inputs.add(innerList);
			} else {
				String[] splitType = t.toString().split(" ");
				String type = splitType[1];
				try {
					Class<?> c = Class.forName(type);
					String s = myInputParameters.get(i);
					if (t.toString().contains("String")) {
						inputs.add(s);
					} else {
						Method parseMethod = c.getMethod("valueOf",
								new Class[] { String.class });
						Object innerObject = parseMethod.invoke(c, s);
						inputs.add(innerObject);
					}
				} catch (ClassNotFoundException | NoSuchMethodException
						| InvocationTargetException | IllegalAccessException e) {
					ErrorPopUp epu = new ErrorPopUp(e);
					epu.display("Bad Class", false);
				}
			}
		}
		return inputs;

	}

	private void finishCondition() {
		List<Object> inputs = convertInputParameters();

		try {
			Condition c = (Condition) myConstructor.newInstance(inputs
					.toArray());

			c.setIdentifier(new Identifier("Condition", mySelectionWizard
					.getMap().get("name").getInformation()));
			c.setInputMap(displayMap);
			myConditionsCollection.add(c);
			mySelectionWizard.close();
		} catch (InvocationTargetException | IllegalAccessException
				| InstantiationException e) {
			ErrorPopUp epu = new ErrorPopUp(e);
			epu.display("Could not construct", false);
		}
	}

}
