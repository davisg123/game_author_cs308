package gamePlayer.model;

import gamePlayer.view.GameCanvas;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class GamePlayerLoop {

	// private GameEngine myGameEngine;
	private DataWrapper myWrapper;
	private DataHandler myHandler; 
	private Scene myScene;
	private Group myRoot; 
	private VBox myCanvasVBox; 
	private GameCanvas myCanvas;
	
	public void initialize() throws IOException{
		myRoot.getChildren().add(FXMLLoader.load(getClass().getResource("RootLayout.fxml")));
		myScene=new Scene(myRoot, 1000, 1000, Color.WHITE);
		
		initializeGUIElements();
	}
	
	private void initializeGUIComponents() {
		
	}
	
	private void initializeGUIElements(){
		VBox myCanvasVBox = (VBox) myScene.lookup("#canvasVBox");
		myCanvasVBox.getChildren().add(myCanvas.getNode());
	}
	
	
}
