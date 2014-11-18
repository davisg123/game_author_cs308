package gamePlayer.view;

import gamePlayer.model.PlayerModel;
import javafx.scene.control.TabPane;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PlayerView {

	private PlayerModel myPlayerModel;
	private Stage myStage;
	private Scene myScene;
	private BorderPane myRoot;
	private VBox myCanvasVBox;
	private MenuBar myMenuBar;
	private GameCanvas myCanvas;

	public PlayerView(PlayerModel playerModel) {
		myPlayerModel = playerModel;
		myStage = new Stage();
	}

	public void initialize() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("RootLayout.fxml"));
		myRoot = (BorderPane) loader.load();
		RibbonControl myController = loader.<RibbonControl>getController();
		initializeGUIComponents();
		
		String css = this.getClass().getResource("App.css").toExternalForm();
		String tabsURL = "ribbon.css";
		String tabsCSS = this.getClass().getResource(tabsURL).toExternalForm();
		myScene.getStylesheets().addAll(css, tabsCSS);
		
		myScene = new Scene(myRoot, Main.SIZE.width, Main.SIZE.height);
		myStage.setTitle("MY PLAYER VIEW");
		myStage.setScene(myScene);
		myStage.show();

	}

	private void initializeGUIComponents() {
//		myRoot.getChildren().add();
		myMenuBar = new MenuBar();
		myCanvas = new GameCanvas();
	}

}