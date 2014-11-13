package authoring;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * Currently a general controller that allows the user to change properties of
 * objects (like change size, initial positions, events). This communicates
 * directly with the model. We may break this up later into multiple controllers
 * for sprites, levels, events.
 *
 */
public class AuthoringController implements Initializable {
	AuthoringView myView;
	/**
	 * Each @FXML declaration defines a GenericGUIFeature object for FXML,
	 * allowing the classes to be parsed using an FXMLLoader
	 */

	@FXML
	private Button myTestButton;

//	public AuthoringController(){
//		myTestButton.setOnAction(event -> {System.out.println("fgDFh"); });
//	}
	
	/**
	 * Generate all of the GUI Features and pass them this Controller, allowing
	 * the Controller to handle all information to be passed through the GUI
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TestButtonController t = new TestButtonController(myTestButton);
		System.out.println(myTestButton.getText());
	}

	public void setView(AuthoringView view) {
		myView = view;
	}

	@FXML
	public void testMethod(ActionEvent event) {
		System.out.println("hi");
	}

	@FXML
	private Pane myPane; // the yellow Pane object has fxid myPane

	public void showPane() {
		myPane.setVisible(true);

	}

}
