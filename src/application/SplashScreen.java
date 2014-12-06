package application;

import java.io.IOException;

import authoring.model.AuthoringModel;
import gamePlayer.model.PlayerModel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SplashScreen {

	private Scene myScene;
	private BorderPane myPane;
	private Button myAuthorButton;
	private Button myPlayButton;
	private AuthoringModel myAuthoringModel;
	private PlayerModel myPlayerModel;
	protected Stage myStage;

	public SplashScreen() {
		myStage = new Stage();
		myPane = new BorderPane();
		initializeButtons();
		myScene = new Scene(myPane);
		myScene.getStylesheets().add(getClass().getResource("layoutstyles.css").toExternalForm());
		myStage.setScene(myScene);
	}

	public void show() {
		myStage.show();
	}

	private void initializeButtons() {
		myAuthorButton = new Button("Authoring Environment");
		myAuthorButton.setOnAction((event) -> {
			myStage.close();
			author();
		});

		myPlayButton = new Button("Player Environment");
		myPlayButton.setOnAction((event) -> {
			try {
				play();
			} catch (Exception e) {

			}
		});

		VBox myButtonsVBox = new VBox();
		myButtonsVBox.getStyleClass().add("vbox");
		myButtonsVBox.getChildren().addAll(myAuthorButton, myPlayButton);
		myPane.setCenter(myButtonsVBox);
	}

	private void author() {
		myAuthoringModel = new AuthoringModel();
	}

	private void play() throws IOException {
		myPlayerModel = new PlayerModel();
		myPlayerModel.initializeView();
	}

}