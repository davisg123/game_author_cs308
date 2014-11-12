package application;

import java.io.IOException;

import viewcontroller.View;
import gamePlayer.model.GamePlayerLoop;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class SplashScreen {

	private Scene myScene;
	private Group myGroup;
	private Button myAuthorButton; 
	private Button myPlayButton;
	//private AuthoringEnvironmentObject myAuthoringEnvironmentObject
	private GamePlayerLoop myGamePlayerLoop; 
	
	public Scene initialize() {
		myGroup = new Group();
		initializeButtons();
		myGroup.getChildren().addAll(myAuthorButton, myPlayButton);
		myScene = new Scene(myGroup, 1000, 1000, Color.WHITE);
		return myScene;
	}
	
	private void initializeButtons() {
		myAuthorButton = new Button();
		myAuthorButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				myStage.close();
				View view = new View(myStage, myLanguageChooser.getValue());
				view.init();
			}
		});
		myPlayButton = new Button();
	}

	private void play() throws IOException{
		myGamePlayerLoop.initialize();
	}
	
	private void author(){
		//
	}
	
	
	

}
