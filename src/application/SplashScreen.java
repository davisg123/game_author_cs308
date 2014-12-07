package application;

import java.io.IOException;
import java.util.Locale;

import authoring.view.AuthoringScene;
import gamePlayer.model.PlayerModel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class SplashScreen {

	private Scene myScene;
	private static final double SCREEN_WIDTH = Screen.getPrimary()
			.getVisualBounds().getWidth() * 3 / 4;
	private static final double SCREEN_HEIGHT = Screen.getPrimary()
			.getVisualBounds().getHeight() * 4 / 5;
	private BorderPane myPane;
	private Text myTitleText;
	private Button myAuthorButton;
	private Button myPlayButton;
	private AuthoringScene myAuthoringScene;
	private PlayerModel myPlayerModel;
	protected Stage myStage;

	public SplashScreen() {
		myStage = new Stage();
		myPane = new BorderPane();
		initializeGUIElements();
		myScene = new Scene(myPane);
		myScene.getStylesheets().add(getClass().getResource("layoutstyles.css").toExternalForm());
		myStage.setScene(myScene);
	}

	public void show() {
		myStage.show();
	}

	private void initializeGUIElements() {
		myTitleText = new Text("VOOGA SALAD\n" + "BITS PLEASE\n" + "PLATFORM SCROLLER");
		myTitleText.setId("text");
		
		myAuthorButton = new Button("Author a Game!");
		myAuthorButton.setOnAction((event) -> {
			myStage.close();
			author();
		});

		myPlayButton = new Button("Play a Game!");
		myPlayButton.setOnAction((event) -> {
			try {
				play();
			} catch (Exception e) {

			}
		});

		VBox myButtonsVBox = new VBox();
		myButtonsVBox.getStyleClass().add("vbox");
		myButtonsVBox.getChildren().addAll(myTitleText, myAuthorButton, myPlayButton);
		myPane.setCenter(myButtonsVBox);
	}

	private void author() {
		Locale myDefaultLocale = new Locale("en", "US");
		myAuthoringScene = new AuthoringScene(myStage, myDefaultLocale, SCREEN_WIDTH,
				SCREEN_HEIGHT);
		myStage.setScene(myAuthoringScene.getScene());
		myStage.show();
	}

	private void play() throws IOException {
		myPlayerModel = new PlayerModel();
		myPlayerModel.initializeView();
		myStage.close();
	}

}