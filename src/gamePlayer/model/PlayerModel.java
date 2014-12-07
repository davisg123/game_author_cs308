package gamePlayer.model;

import java.io.IOException;

import javafx.stage.FileChooser;
import data.DataManager;
import application.SplashScreen;
import authoring.model.GameData;
import authoring.model.collections.ConditionsCollection;
import engine.GameManager;
import engine.conditions.ButtonCondition;
import engine.conditions.Condition;
import gamePlayer.view.FileSelectionWizard;
import gamePlayer.view.PlayerView;

/**
 * 
 * @author Abhishek B
 * @author Shreyas B
 * 
 */
public class PlayerModel {

	private GameData myGameData;
	private DataManager myManager; 
	private PlayerView myPlayerView;
	private GameManager myGameManager;
	private ConditionsCollection myButtonConditions;
	private FileSelectionWizard myFileSelector;
	
	public PlayerModel() {
		myPlayerView = new PlayerView(this);
		myManager = new DataManager();
		myButtonConditions = new ConditionsCollection();
		myFileSelector = new FileSelectionWizard();
	}
	
	public void initializeView() throws IOException {
		myPlayerView.initialize();
	}
	
	public void loadGameFile() {
		myGameData = myManager.readGameFile(myFileSelector.selectFile());
		myGameManager = new GameManager(myGameData.getConditions(), myGameData.getGameObjects(), myGameData.getLevels(), myPlayerView.getGroup());
		myGameManager.initialize();
		
		extractButtonConditions();
	}
	
	public ConditionsCollection getButtonConditions(){
		return myButtonConditions;
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
	
	private void extractButtonConditions() {
		ConditionsCollection conditions = myGameData.getConditions();
		for(Condition c : conditions) {
			if (c instanceof ButtonCondition)
				myButtonConditions.add(c);
		}
	}
	
}
