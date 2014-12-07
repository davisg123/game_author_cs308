package authoring.view.wizardview;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import authoring.view.propertiesview.PropertyTextField;

public class LevelWizard extends Wizard{


	public LevelWizard(String title, double width, double height,
			EventHandler<ActionEvent> event) {
		super(title, width, height, event);
	}

	@Override
	public VBox initializeWizard(EventHandler<ActionEvent> event) {
		myWindow = new VBox();
		
		PropertyTextField nameField = new PropertyTextField("Name: ", "");
		myMap.put("name", nameField);
		
		super.addMapToWindow();
		
		Button add = new Button("Add Level");
		add.setOnAction(event);
		myWindow.getChildren().add(add);
		
		return myWindow;
	}



}
