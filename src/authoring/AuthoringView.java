package authoring;

import java.io.IOException;

import authoring.AuthoringController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
				"randotest.fxml"));
		Parent root;
		root = fxmlLoader.load();
		//myController = (AuthoringController) fxmlLoader.getController();

		this.myScene = new Scene(root, 840, 658);
		this.myStage.setTitle("Dinkey");
		this.myStage.setScene(myScene);
		this.myStage.show();
	}

}
