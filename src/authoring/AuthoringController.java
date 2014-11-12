package authoring;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;



/**
 * Currently a general controller that allows the user
 * to change properties of objects (like change size, initial positions,
 * events). This communicates directly with the model.
 * We may break this up later into multiple controllers
 * for sprites, levels, events.
 *
 */
public class AuthoringController implements Initializable {
	AuthoringView myView;
	/**
	 * Each @FXML declaration defines a GenericGUIFeature object for FXML,
	 * allowing the classes to be parsed using an FXMLLoader
	 */
	
		/**
	 * Generate all of the GUI Features and pass them this Controller, allowing
	 * the Controller to handle all information to be passed through the GUI
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	public void setView(AuthoringView view){
		myView = view;
	}
	
	@FXML
	public void testMethod(ActionEvent event){
		System.out.println("hi");
	}

}
