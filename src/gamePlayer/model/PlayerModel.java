package gamePlayer.model;

import gamePlayer.view.FileSelectionWizard;
import gamePlayer.view.PlayerView;

import java.io.File;
import java.io.IOException;

import application.SplashScreen;
import authoring.model.GameData;
import authoring.model.collections.ConditionsCollection;
import data.DataManager;
import engine.GameManager;
import engine.conditions.ButtonCondition;
import engine.conditions.Condition;

/**
 * 
 * @author Abhishek B
 * @author Shreyas B
 * 
 */
public class PlayerModel {

	private GameData myGameData;
	private DataManager myDataManager;
	private PlayerView myPlayerView;
	private GameManager myGameManager;
	private ConditionsCollection myButtonConditions;
	private FileSelectionWizard myFileSelector;

	public PlayerModel() {
		myPlayerView = new PlayerView(this);
		myDataManager = new DataManager();
		myButtonConditions = new ConditionsCollection();
		myFileSelector = new FileSelectionWizard();
	}
	
	public void initializeView() throws IOException {
		myPlayerView.initialize();
	}

	public void loadGameFile() {
		File f = myFileSelector.selectFile();
		System.out.println(f.getAbsolutePath());
		myGameData = myDataManager.readGameFile(f);
		if(myGameData == null) System.out.println("Null!!!!");
		myGameManager = new GameManager(myGameData.getConditions(), myGameData.getGameObjects(), myGameData.getLevels(), myPlayerView.getGroup(), f.getAbsolutePath());
		myGameManager.initialize();
		extractButtonConditions();
	}

	public void saveGameToWeb() {
		
	}
	
	public void fetchGameFromWeb() {
		
	}
	
	public ConditionsCollection getButtonConditions() {
		return myButtonConditions;
	}

	/**
	 * Clear the game and close this stage
	 * Return to the splash screen
	 */
	public void exitFromGame() {
		myGameManager.clear();
		myPlayerView.close();
		SplashScreen screen = new SplashScreen();
		screen.show();
	}

	public void pauseGame() {
		myGameManager.togglePause();
	}

	private void extractButtonConditions() {
		ConditionsCollection conditions = myGameData.getConditions();
		for (Condition c : conditions) {
			if (c instanceof ButtonCondition)
				myButtonConditions.add(c);
		}
	}

	/**
	 * This will save a file wtih file selector
	 */
	public void saveGameProgress() {
//		myDataManager.writeGameFile(myGameManager.getGameData(), );
	}
	
	/**
	 * This will load a file with file selector
	 */
	public void loadGameProgress() {
	
	}

}
