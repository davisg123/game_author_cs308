package authoring.view.wizards;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import authoring.view.propertiesview.PropertyTextField;

public class ConditionSelectionWizard extends Wizard {

	private ConditionChoicesVBox myChoices;
	private Button selectParametersButton;
	//private Button addActionButton;
	private Button finalizeButton;
	
	public ConditionSelectionWizard(String title, double width, double height,
			EventHandler<ActionEvent> event) {
		super(title, width, height, event);
		
	}

	@Override
	public VBox initializeWizard(EventHandler<ActionEvent> event) {
		myMap.put("name", new PropertyTextField("Name: ", ""));
		
		super.addMapToWindow();
		
		myChoices = new ConditionChoicesVBox();
		
		myWindow.getChildren().add(myChoices);
		
		selectParametersButton = new Button("Select Parameters");
		selectParametersButton.setOnAction(event);
		myWindow.getChildren().add(selectParametersButton);
		
		
//		addActionButton = new Button("Add Actions");
//		myWindow.getChildren().add(addActionButton);
//		addActionButton.setDisable(true);
		
		finalizeButton = new Button("Finalize Condition");
		myWindow.getChildren().add(finalizeButton);
		finalizeButton.setDisable(true);
		
		return myWindow;
	}
	
	public String getSelectedCondition(){
		return myChoices.getSelected();
	}
	
	public void disableSelection(){
		myChoices.setDisable(true);
	}
	
//	public void enableActionCreation(EventHandler<ActionEvent> event){
//		addActionButton.setOnAction(event);
//		addActionButton.setDisable(false);
//	}

	public void enableFinalize(EventHandler<ActionEvent> event) {
		finalizeButton.setOnAction(event);
		finalizeButton.setDisable(false);
	}

}