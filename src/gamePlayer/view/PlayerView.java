package gamePlayer.view;

import gamePlayer.model.DataHandler;
import gamePlayer.model.DataWrapper;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PlayerView {

	// private GameEngine myGameEngine;
	private Stage myStage;
	private DataWrapper myWrapper;
	private DataHandler myHandler; 
	private Scene myScene;
	private Group myRoot; 
	private VBox myCanvasVBox; 
	private GameCanvas myCanvas;
	
	public PlayerView() {
		myStage = new Stage();
	}
	
	public void initialize() throws IOException{
		myRoot.getChildren().add(FXMLLoader.load(getClass().getResource("RootLayout.fxml")));
		myScene=new Scene(myRoot, 1000, 1000, Color.WHITE);
		
		initializeGUIElements();
	}
	
	private void initializeGUIComponents() {
		myCanvas = new GameCanvas();
	}
	
	private void initializeGUIElements(){
		VBox myCanvasVBox = (VBox) myScene.lookup("#canvasVBox");
		myCanvasVBox.getChildren().add(myCanvas.getNode());
	}	
	
}
