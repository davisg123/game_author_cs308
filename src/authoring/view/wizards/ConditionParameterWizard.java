package authoring.view.wizards;

import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import authoring.view.propertiesview.PropertyTextField;

public class ConditionParameterWizard extends Wizard{

	private Parameter[] myParameterTypes;
	private Class<?> myConditionClass;
	
	private static final ResourceBundle CONDITION_PARAMETERS = ResourceBundle.getBundle("assets/conditionsParameters");
	
	public ConditionParameterWizard(String title, double width, double height, Parameter[] pTypes, Class<?> conditionClass,
			EventHandler<ActionEvent> event) {
		super(title, width, height, event);
		myParameterTypes = pTypes;
		myConditionClass = conditionClass;
		showParameters(event);
	}

	@Override
	public VBox initializeWizard(EventHandler<ActionEvent> event) {
		return myWindow;
	}
	
	private void showParameters(EventHandler<ActionEvent> event){
		//since we need to assign parameter types after initializing, this is essentially this wizard's "initialize"
		//System.out.println(Arrays.deepToString(myParameterTypes));

		String[] classPath = myConditionClass.toString().split("\\.");
		String params = CONDITION_PARAMETERS.getString(classPath[classPath.length-1]);
		
		String[] paramArray = params.split(",");
		for(String s: paramArray){
			myMap.put(s, new PropertyTextField(s, ""));
		}
		super.addMapToWindow();
		
		Button addButton = new Button("Continue");
		addButton.setOnAction(event);
		myWindow.getChildren().add(addButton);
		
	}
	
	

}
