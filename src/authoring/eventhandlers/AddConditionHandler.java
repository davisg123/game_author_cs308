package authoring.eventhandlers;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javafx.event.Event;
import javafx.event.EventType;
import authoring.model.collections.ConditionsCollection;
import authoring.view.wizards.ActionChoiceWizard;
import authoring.view.wizards.ConditionParameterWizard;
import authoring.view.wizards.ConditionSelectionWizard;
import engine.actions.Action;
import engine.conditions.Condition;
import engine.gameObject.Identifier;

public class AddConditionHandler implements GameHandler<Event> {

	private static final String CONDITION_PATH_START = "engine.conditions.";
	private static final int WIZARD_WIDTH = 300;
	private static final int WIZARD_HEIGHT = 600;

	private ConditionSelectionWizard mySelectionWizard;
	private ConditionParameterWizard myCPW;
	private ActionChoiceWizard myActionChoiceWizard;

	private List<String> myInputParameters;
	private Parameter[] myParameterTypes;
	private Class<?> classType;
	private Constructor myConstructor;
	
	private ConditionsCollection myConditionsCollection;
	
	public AddConditionHandler(ConditionsCollection conditions){
		myConditionsCollection = conditions;
	}
	
	@Override
	public void handle(Event arg0) {
		mySelectionWizard = new ConditionSelectionWizard("New Condition", WIZARD_WIDTH,
				WIZARD_HEIGHT, event -> createCondition());
	}

	@Override
	public EventType<Event> getEventType() {
		return Event.ANY;
	}

	private void createCondition() {
		String selected = mySelectionWizard.getSelectedCondition();

		try {
			classType = Class.forName(CONDITION_PATH_START + selected);
			//System.out.println(classType.toString());

		
			
			Constructor[] constructors = classType.getDeclaredConstructors();
			myConstructor = constructors[0];
			myParameterTypes = constructors[0].getParameters();

			
			
			for (Parameter p : myParameterTypes){
				System.out.println(p.getParameterizedType());
			}

			//System.out.println(Arrays.deepToString(myParameterTypes));

			myCPW = new ConditionParameterWizard("Choose Parameters",
					WIZARD_WIDTH, WIZARD_HEIGHT, myParameterTypes, classType,
					event -> fillConditionParameters());

		} catch (ClassNotFoundException e) {
			System.out.println("Bad Class");
		}

	}

	private void fillConditionParameters() {
		System.out.println("filling conditions");
		myInputParameters = new ArrayList<String>();
		for (String s : myCPW.getMap().keySet()) {
			myInputParameters.add(myCPW.getMap().get(s).getInformation());
		}
		mySelectionWizard.disableSelection();
		//myWizard.enableActionCreation(event -> addAction());
		mySelectionWizard.enableFinalize(event -> finishCondition());
		myCPW.close();
	}

//	private void addAction() {
//		myActionChoiceWizard = new ActionChoiceWizard("Choose Action",
//				WIZARD_WIDTH, WIZARD_HEIGHT, event -> createAction());
//
//	}
//
//	private void createAction() {
//		System.out.println("heyah");
//	}

	private Object[] convertInputParameters() {
		List<Object> inputs = new ArrayList<Object>();
		inputs.add(new ArrayList<Action>());
		for(int i = 0; i < myInputParameters.size(); i++){
			Type t = myParameterTypes[i+1].getParameterizedType();
			if(t.toString().contains("List")){
				String[] splitType = t.toString().split("\\<");
				String type = splitType[splitType.length-1].replace(">", "");
				List<Object> innerList = new ArrayList<Object>();
				try {
					Class c = Class.forName(type);
					Method parseMethod = c.getMethod("valueOf", new Class[]{String.class});
					for(String s : myInputParameters.get(i).split("\\;")){
						innerList.add(parseMethod.invoke(c, s));
						//System.out.println(parseMethod.invoke(c, s));
					}
					//System.out.println(parseMethod.invoke(c, myInputParameters.get(i)).getClass());
				} catch (Exception e) {
					System.out.println("Bad Class");
				}
				inputs.add(innerList);
			}else{
				String[] splitType = t.toString().split(" ");
				String type = splitType[1];
				//System.out.println(type);
				Object innerObject = new Object();
				try {
					Class c = Class.forName(type);
					//System.out.println(c.getFields()[0].getType().toString());
					Method parseMethod = c.getMethod("valueOf", new Class[]{String.class});
					String s = myInputParameters.get(i);
					parseMethod.invoke(c, s);
					//System.out.println(parseMethod.invoke(c, s));
					//System.out.println(parseMethod.invoke(c, myInputParameters.get(i)).getClass());
				} catch (Exception e) {
					System.out.println("Bad Class");
				}
				inputs.add(innerObject);
			}
		}
		return inputs.toArray();
		
	}
	
	private void finishCondition(){
		Object[] inputs = convertInputParameters();
		try {
			Condition c = (Condition) myConstructor.newInstance(inputs);
			c.setIdentifier(new Identifier("Condition", mySelectionWizard.getMap().get("name").getInformation()));
			myConditionsCollection.add(c);
			mySelectionWizard.close();
			System.out.println(c.getClass());
		} catch (Exception e) {
			System.out.println("Could not construct");
			e.printStackTrace();
		}
	}

}
