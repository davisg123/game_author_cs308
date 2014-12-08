package authoring.view.wizards;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import authoring.view.propertiesview.PropertyTextField;

public class ActionChoiceWizard extends Wizard {

	private ActionChoicesVBox myChoices;
	
	public ActionChoiceWizard(String title, double width, double height,
			EventHandler<ActionEvent> event) {
		super(title, width, height, event);
		
	}

	@Override
	public VBox initializeWizard(EventHandler<ActionEvent> event) {
		super.addMapToWindow();
		
		myChoices = new ActionChoicesVBox();
		
		myWindow.getChildren().add(myChoices);
		
		Button addButton = new Button("Continue");
		addButton.setOnAction(event);
		myWindow.getChildren().add(addButton);
		
		return myWindow;
	}
	
	public String getSelectedAction(){
		return myChoices.getSelected();
	}

}