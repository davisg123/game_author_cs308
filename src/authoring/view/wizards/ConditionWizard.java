package authoring.view.wizards;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import authoring.view.propertiesview.PropertyTextField;

public class ConditionWizard extends Wizard {

	private ConditionChoicesVBox myChoices;
	
	public ConditionWizard(String title, double width, double height,
			EventHandler<ActionEvent> event) {
		super(title, width, height, event);
		
	}

	@Override
	public VBox initializeWizard(EventHandler<ActionEvent> event) {
		myMap.put("name", new PropertyTextField("Name: ", ""));
		
		super.addMapToWindow();
		
		myChoices = new ConditionChoicesVBox();
		
		myWindow.getChildren().add(myChoices);
		
		Button addButton = new Button("Continue");
		addButton.setOnAction(event);
		myWindow.getChildren().add(addButton);
		
		return myWindow;
	}
	
	public String getSelectedCondition(){
		return myChoices.getSelected();
	}

}