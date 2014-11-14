package gamePlayer.view;

import gamePlayer.model.PlayerModel;
import java.io.IOException;
import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PlayerView {

	private PlayerModel myPlayerModel;
	private Stage myStage;
	private Scene myScene;
	private Group myRoot;
	private VBox myCanvasVBox;
	private GameCanvas myCanvas;

	public PlayerView(PlayerModel playerModel) {
		myPlayerModel = playerModel;
		myStage = new Stage();
		myRoot = new Group();
		myScene = new Scene(myRoot, Main.SIZE.width, Main.SIZE.height);
		myStage.setTitle("MY PLAYER VIEW");
		myStage.setScene(myScene);
		myStage.show();
	}

	public void initialize() throws IOException {
		myRoot.getChildren().add(
				FXMLLoader.load(getClass().getResource("RootLayout.fxml")));
		initializeGUIComponents();
		initializeGUIElements();
	}

	private void initializeGUIComponents() {
		myCanvas = new GameCanvas();
	}

	private void initializeGUIElements() {
		MenuBar myMenuBar = (MenuBar) myScene.lookup("#menuBar");
		myCanvasVBox = (VBox) myScene.lookup("#canvasVBox");
		myCanvasVBox.getChildren().add(myCanvas.getNode());
		myRoot.getChildren().addAll(myMenuBar, myCanvasVBox);
	}
}