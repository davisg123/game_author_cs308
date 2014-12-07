package gamePlayer.model;

import java.io.IOException;
import java.util.Iterator;

import data.DataManager;
import application.SplashScreen;
import authoring.model.GameData;
import authoring.model.collections.ConditionsCollection;
import engine.GameManager;
import engine.conditions.ButtonCondition;
import engine.conditions.Condition;
import gamePlayer.view.PlayerView;

public class PlayerModel {

	private GameData myGameData;
	private DataManager myManager; 
	private PlayerView myPlayerView;
	private GameManager myGameManager;
	private ConditionsCollection myButtonConditions;
	
	public PlayerModel() throws IOException {
		myPlayerView = new PlayerView(this);
		myManager = new DataManager();
	}
	
	public void initializeView() throws IOException {
		myPlayerView.initialize();
	}
	
	public void loadGameFile() {
		myGameData = myManager.readGameFile("fd_final.json");
		myGameManager = new GameManager(myGameData.getConditions(), myGameData.getGameObjects(), myGameData.getLevels(), myPlayerView.getGroup());
		myGameManager.initialize();
		
		extractButtonConditions();
	}
	
	public void exitFromGame(){
		myPlayerView.close();
		SplashScreen screen = new SplashScreen();
		screen.show();
	}

	public void pauseGame(){
		myGameManager.togglePause(); 
	}
	
	private void extractButtonConditions() {
/*		myButtonConditions = new ConditionsCollection();
		ConditionsCollection conditions = myGameData.getConditions();
		for (Iterator<Condition> conditionIterator = conditions.iterator(); conditionIterator.hasNext();) {
			Condition condition = conditionIterator.next();
			if(condition instanceof ButtonCondition) {
				myButtonConditions.add(condition);
			}
		} */
	}
	
	public ConditionsCollection getButtonConditions() {
		return myButtonConditions;
	}
	
}
