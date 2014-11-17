package gamePlayer.model;

import java.io.IOException;

import application.SplashScreen;
import engine.GameManager;
import gamePlayer.view.PlayerView;

public class PlayerModel {

	private DataWrapper myWrapper;
	private DataWrapper myWorkingWrapper;
	private DataHandler myHandler; 
	private PlayerView myPlayerView;
	private GameManager myGameManager; 
	
	public PlayerModel() throws IOException {
		myPlayerView = new PlayerView(this);
		myHandler = new DataHandler();
	}
	
	public void initializeView() throws IOException {
		myPlayerView.initialize();
	}
	
	public void loadGame() throws CloneNotSupportedException{
		System.out.println("it works");
//		myWrapper = myHandler.getSavedData();
//		myWorkingWrapper=myWrapper.copyOf();
//		myGameManager = new GameManager(myWorkingWrapper.getConditions(), myWorkingWrapper.getSprites(), myPlayerView.getGroup());
		//myGameManager.initialize();
	}
	
	public void newGame(){
		myWrapper = myHandler.getNewData();
		//myGameManager = new GameManager(myWorkingWrapper.getConditions(), myWorkingWrapper.getSprites(), myPlayerView.getGroup());
		//myGameManager.initialize();
	}
	
	public void quitGame(){
		//myGameManager.clear()
		myPlayerView.close();
		SplashScreen screen = new SplashScreen();
		screen.show();
		
	}
	
	public void saveGame(){
		//myHandler.saveData(myWorkingWrapper);
	}
	
	
}
