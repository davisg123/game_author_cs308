package authoring.view.wizardview;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import authoring.view.propertiesview.GameObjectProperties;

public class GameObjectWizard extends Wizard{

	public GameObjectWizard(String title, double width, double height,
			EventHandler<ActionEvent> event) {
		super(title, width, height, event);
	}

	@Override
	public VBox initializeWizard(EventHandler<ActionEvent> event) {
		myMap = (new GameObjectProperties()).getClearedTextMap(); //gets empty map
		
		super.addMapToWindow();
		
		Button add = new Button("Add Game Object");
		add.setOnAction(event);
		myWindow.getChildren().add(add);
		
		return myWindow;
		
		
	}

}
