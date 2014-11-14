package application;

import java.io.IOException;

import gamePlayer.view.PlayerView;
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
	//private AuthoringEnvironmentObject myAuthoringEnvironmentObject
	private PlayerView myPlayerView;
	protected Stage myStage;
	
	public SplashScreen() {
		myStage = new Stage();
		myGroup = new Group();
		initializeButtons();
		myGroup.getChildren().addAll(myAuthorButton, myPlayButton);
		myScene = new Scene(myGroup, 1000, 1000, Color.WHITE);
		myStage.setScene(myScene);
	}
	
	public void show() {
		myStage.show();
	}
	
	private void initializeButtons() {
		myAuthorButton = new Button();
		myAuthorButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
			}
		});
		
		myPlayButton = new Button();
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

	private void play() throws IOException{
		myPlayerView.initialize();
	}
	
	private void author(){
		//
	}
	
	
	

}
