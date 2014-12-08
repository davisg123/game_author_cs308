package authoring.view.wizards;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import authoring.view.propertiesview.PropertyTextField;

public class ConditionWizard extends Wizard {

	public ConditionWizard(String title, double width, double height,
			EventHandler<ActionEvent> event) {
		super(title, width, height, event);
		
	}

	@Override
	public VBox initializeWizard(EventHandler<ActionEvent> event) {
		myMap.put("name", new PropertyTextField("Name: ", ""));
		
		
		
		return myWindow;
	}

}
