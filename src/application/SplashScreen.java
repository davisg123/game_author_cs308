package application;

import java.io.IOException;

import authoring.model.AuthoringModel;
import authoring.view.AuthoringScene;
import gamePlayer.model.PlayerModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SplashScreen {

	private Scene myScene;
	private Group myGroup;
	private Button myAuthorButton;
	private Button myPlayButton;
	private AuthoringModel myAuthoringModel;
	private PlayerModel myPlayerModel;
	protected Stage myStage;

	public SplashScreen() {
		myStage = new Stage();
		myGroup = new Group();
		initializeButtons();
		myGroup.getChildren().addAll(myAuthorButton, myPlayButton);
		myScene = new Scene(myGroup, 100, 100, Color.WHITE);
		myStage.setScene(myScene);
	}

	public void show() {
		myStage.show();
	}

	private void initializeButtons() {
		myAuthorButton = new Button("Authoring Environment");
		myAuthorButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				myStage.close();
				author();
			}
		});

		myPlayButton = new Button("Player Environment");
		myPlayButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				myStage.close();
				try {
					play();
				} catch (IOException e) {

				}
			}
		});
	}
	
	private void author() {
		primaryStage.setResizable(false);
		myScene = new AuthoringScene(primaryStage, myDefaultLocale, SCREEN_WIDTH,
				SCREEN_HEIGHT);
		primaryStage.setScene(myScene.getScene());
		primaryStage.show();
	}

	private void play() throws IOException {
		myPlayerModel = new PlayerModel();
		myPlayerModel.initializeView();
	}

}
