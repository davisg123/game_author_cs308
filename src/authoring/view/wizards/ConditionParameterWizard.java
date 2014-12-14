package authoring.view.wizards;

import static authoring.view.wizards.ActionChoicesVBox.ACTIONS_PARAMETERS;
import static authoring.view.wizards.ConditionChoicesVBox.CONDITIONS_PARAMETERS;

import java.lang.reflect.Parameter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import authoring.view.propertiesview.PropertyTextField;

/**
 * @author Kevin Li
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Arjun Jain
 */
public class ConditionParameterWizard extends Wizard {

	private Parameter[] myParameterTypes;
	private Class<?> myConditionClass;

	public ConditionParameterWizard(String title, double width, double height,
			Parameter[] pTypes, Class<?> conditionClass,
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

	private void showParameters(EventHandler<ActionEvent> event) {
		// since we need to assign parameter types after initializing, this is
		// essentially this wizard's "initialize"

		String[] classPath = myConditionClass.toString().split("\\.");
		String className = classPath[classPath.length - 1];

		String params;
		if (className.contains("Condition")) {
			params = CONDITIONS_PARAMETERS.getString(className);
		} else {
			params = ACTIONS_PARAMETERS.getString(className);
		}

		System.out.println(params);

		String[] paramArray = params.split(",");
		for (String s : paramArray) {
			myMap.put(s, new PropertyTextField(s, ""));
		}
		super.addMapToWindow();

		Button addButton = new Button("Continue");
		addButton.setOnAction(event);
		myWindow.getChildren().add(addButton);

	}

}
