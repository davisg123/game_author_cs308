package gamePlayer.model;

import java.io.IOException;

import data.DataManager;
import application.SplashScreen;
import authoring.model.GameData;
import engine.GameManager;
import gamePlayer.view.PlayerView;

public class PlayerModel {

	private GameData myGameData;
	private DataManager myManager; 
	private PlayerView myPlayerView;
	private GameManager myGameManager; 
	
	public PlayerModel() throws IOException {
		myPlayerView = new PlayerView(this);
		myManager = new DataManager();
	}
	
	public void initializeView() throws IOException {
		myPlayerView.initialize();
	}
	
	public void loadGameFile(){		
		myGameData = myManager.readGameFile("TestFile");
		myGameManager = new GameManager(myGameData.getConditions(), myGameData.getGameObjects(), myGameData.getLevels(), myPlayerView.getGroup());
		myGameManager.initialize();
	}
	
	public void exitFromGame(){
		//myGameManager.clear()
		myPlayerView.close();
		SplashScreen screen = new SplashScreen();
		screen.show();	
		}

	public void pauseGame(){
		myGameManager.togglePause(); 
	}
	
}
