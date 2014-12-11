package authoring.eventhandlers;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javafx.event.Event;
import javafx.event.EventType;
import authoring.view.wizards.ActionChoiceWizard;
import authoring.view.wizards.ConditionParameterWizard;
import engine.actions.Action;
import engine.conditions.Condition;

public class AddActionHandler implements GameHandler<Event> {

	private static final String CONDITION_PATH_START = "engine.actions.";
	private static final int WIZARD_WIDTH = 300;
	private static final int WIZARD_HEIGHT = 600;
	
	private ActionChoiceWizard myActionSelectionWizard;
	private ConditionParameterWizard myCPW;
	
	private List<String> myInputParameters;
	private Parameter[] myParameterTypes;
	private Class<?> classType;
	private Constructor myConstructor;
	
	private Condition myCondition;

	public AddActionHandler() {

	}

	@Override
	public void handle(Event arg0) {
		myActionSelectionWizard = new ActionChoiceWizard("New ", WIZARD_WIDTH,
				WIZARD_HEIGHT, event -> createAction());
	}
	
	private void createAction(){
		String selected = myActionSelectionWizard.getSelectedAction();
		
		try {
			classType = Class.forName(CONDITION_PATH_START + selected);
			//System.out.println(classType.toString());

			Constructor[] constructors = classType.getDeclaredConstructors();
			myConstructor = constructors[0];
			myParameterTypes = constructors[0].getParameters();
			System.out.println(myConstructor);

			
			
			for (Parameter p : myParameterTypes){
				System.out.println(p.getParameterizedType());
			}

			//System.out.println(Arrays.deepToString(myParameterTypes));

			myCPW = new ConditionParameterWizard("Choose Parameters",
					WIZARD_WIDTH, WIZARD_HEIGHT, myParameterTypes, classType,
					event -> finishAction());
			myActionSelectionWizard.close();

		} catch (ClassNotFoundException e) {
			System.out.println("Bad Class");
		}

	}
	
	private void finishAction(){
		myInputParameters = new ArrayList<String>();
		for (String s : myCPW.getMap().keySet()) {
			myInputParameters.add(myCPW.getMap().get(s).getInformation());
		}
		List<Object> inputs = convertInputParameters();
		System.out.println(inputs);
		try {
			Action a = (Action) myConstructor.newInstance(inputs.toArray());
			//a.setIdentifier(new Identifier("Condition", mySelectionWizard.getMap().get("name").getInformation()));
			System.out.println(a.getClass());
			myCondition.addAction(a);
			myCPW.close();
		} catch (Exception e) {
			System.out.println("Could not construct");
			e.printStackTrace();
		}
	}
		
	private List<Object> convertInputParameters() {
		List<Object> inputs = new ArrayList<Object>();
		for(int i = 0; i < myInputParameters.size(); i++){
			Type t = myParameterTypes[i].getParameterizedType();
			if(t.toString().contains("List")){
				String[] splitType = t.toString().split("\\<");
				String type = splitType[splitType.length-1].replace(">", "");
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
				} catch (Exception e) {
					System.out.println("Bad Class");
				}
				inputs.add(innerList);
			}else{
				String[] splitType = t.toString().split(" ");
				String type = splitType[1];
				try {
					Class<?> c = Class.forName(type);	
					String s = myInputParameters.get(i);
					if(t.toString().contains("String")){
						inputs.add(s);
					}else{
						Method parseMethod = c.getMethod("valueOf",new Class[] { String.class });
						Object innerObject = parseMethod.invoke(c, s);
						inputs.add(innerObject);
					}
				} catch (Exception e) {
					System.out.println("Bad Class");
				}
			}
		}
		return inputs;
		
	}

	@Override
	public EventType<Event> getEventType() {
		// TODO Auto-generated method stub
		return Event.ANY;
	}
	
	public void setCondition(Condition c){
		myCondition = c;
	}
}