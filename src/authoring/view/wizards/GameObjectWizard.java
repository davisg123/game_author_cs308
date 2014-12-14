package authoring.view.wizards;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import authoring.view.propertiesview.GameObjectProperties;

/**
 * @author Kevin Li
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Arjun Jain
 */
public class GameObjectWizard extends Wizard {

	public GameObjectWizard(String title, double width, double height,
			EventHandler<ActionEvent> event) {
		super(title, width, height, event);
	}

	@Override
	public VBox initializeWizard(EventHandler<ActionEvent> event) {
		myMap = (new GameObjectProperties()).getWizardMap(); // gets empty map

		super.addMapToWindow();

		Button add = new Button("Continue");
		add.setOnAction(event);
		myWindow.getChildren().add(add);

		return myWindow;

	}

}