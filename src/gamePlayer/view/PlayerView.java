package gamePlayer.view;

import engine.conditions.ButtonConditionManager;
import gamePlayer.model.PlayerModel;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PlayerView {

	private PlayerModel myPlayerModel;
	private Stage myStage;
	private Scene myScene;
	private GameCanvas myCanvas;
	private BorderPane myRoot;
	
	public PlayerView(PlayerModel playerModel) {
		myPlayerModel = playerModel;
		myStage = new Stage();
	}

	public void initialize() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("RootLayout.fxml"));
		myRoot = (BorderPane) loader.load();
		MenuBarController myController = loader.<MenuBarController>getController();
		myController.setModel(myPlayerModel);
		myScene = new Scene(myRoot);
        ButtonConditionManager.getInstance().beginListeningToScene(myScene);
		myStage.setTitle("MY PLAYER VIEW");
		myStage.setScene(myScene);
		myStage.show();
		initializeGUIComponents();
	}

	private void initializeGUIComponents() {
		myCanvas = new GameCanvas();
		myRoot.getChildren().add(myCanvas.getNode());
	}
	
	public Group getGroup(){
		return myCanvas.getNode();
	}
	
	public void close(){
		myStage.close();
	}
	
	
}