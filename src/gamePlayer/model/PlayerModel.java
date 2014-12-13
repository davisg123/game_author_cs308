package gamePlayer.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import data.DataManager;
import application.SplashScreen;
import authoring.model.GameData;
import authoring.model.collections.ConditionsCollection;
import engine.GameManager;
import engine.conditions.ButtonCondition;
import engine.conditions.Condition;
import gamePlayer.view.FileSelectionWizard;
import gamePlayer.view.PlayerView;
import gamePlayer.view.ProgressSelector;

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
	private File myGameLocation;
	private ProgressSelector myProgressSelector;

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
		myGameLocation = myFileSelector.selectFile();
		System.out.println(myGameLocation.getAbsolutePath());
		myProgressSelector = new ProgressSelector(myGameLocation);
		loadGameData();
	}

	private void loadGameData() {
		myGameData = myDataManager.readGameFile(myGameLocation);
		if(myGameData == null) System.out.println("Null!!!!");
		myGameManager = new GameManager(myGameData.getConditions(),
				myGameData.getGameObjects(), myGameData.getLevels(),
				myPlayerView.getGroup(), myGameLocation.toString());
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
	 * This will save a file with file selector
	 */
	public void saveGameProgress() {
		String progressName = myProgressSelector.saveProgressState();
		try {
			boolean success = myDataManager.writeProgressFile(myGameData, myGameLocation, progressName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This will load a file with file selector
	 */
	public void loadGameProgress() {
		String progressName = myProgressSelector.loadProgressState();
		myGameData = myDataManager.readProgressFile(myGameLocation, progressName);
		// reinitializes for new GameData file
		loadGameData();
	}

}
