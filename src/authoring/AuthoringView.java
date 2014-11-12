package authoring;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Displays all objects on the screen. Individual components observes components
 * of the Model.
 *
 */
public class AuthoringView {
	Scene myScene;
	Stage myStage;
	AuthoringController myController;
	
	public AuthoringView(Stage stage) throws IOException {
		myStage = stage;
		this.initializeStage();
	}

	private void initializeStage() throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
				"voogatest2.fxml"));
		Parent root;
		root = fxmlLoader.load();
		myController = (AuthoringController) fxmlLoader.getController();
		//myController.setView(this);

		this.myScene = new Scene(root, 840, 658);
		this.myStage.setTitle("Dinkey");
		this.myStage.setScene(myScene);
		this.myStage.show();
	}
}
