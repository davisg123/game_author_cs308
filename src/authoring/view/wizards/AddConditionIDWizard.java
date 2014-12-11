package authoring.view.wizards;

import authoring.view.propertiesview.PropertyTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class AddConditionIDWizard extends Wizard{

	public AddConditionIDWizard(String title, double width, double height,
			EventHandler<ActionEvent> event) {
		super(title, width, height, event);
	}

	@Override
	public VBox initializeWizard(EventHandler<ActionEvent> event) {
		PropertyTextField nameField = new PropertyTextField("Condition ID: ", "");
		myMap.put("ID", nameField);
		
		super.addMapToWindow();
		
		Button add = new Button("Add Condition");
		add.setOnAction(event);
		myWindow.getChildren().add(add);
		
		return myWindow;
	}

}
