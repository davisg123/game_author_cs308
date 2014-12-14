package gamePlayer.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import data.DataManager;
import application.SplashScreen;
import authoring.model.GameData;
import authoring.model.collections.ConditionsCollection;
import engine.GameManager;
import engine.conditions.ButtonPressCondition;
import engine.conditions.Condition;
import errorsAndExceptions.ErrorPopUp;
import gamePlayer.view.FileSelectionWizard;
import gamePlayer.view.PlayerView;
import gamePlayer.view.ProgressSelector;

/**
 * 
 * @author Abhishek B
 * @author Shreyas B
 * @author Eli Lichtenberg
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
	private StringProperty progressFileName;

	public PlayerModel() {
		myPlayerView = new PlayerView(this);
		myDataManager = new DataManager();
		myButtonConditions = new ConditionsCollection();
		myFileSelector = new FileSelectionWizard();
		progressFileName = new SimpleStringProperty();
		addFileNameChangeListener();
	}
	
	// check here
	private void addFileNameChangeListener() {
		progressFileName.addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable,
					String oldValue, String newValue) {
				try {
					myGameData = myDataManager.readProgressFile(myGameLocation, newValue);
					loadGameData();
				} catch (FileNotFoundException e) {
					ErrorPopUp epu = new ErrorPopUp();
					epu.display("File not found", false);
				}
			}
		});
	}
	
	public void initializeView() throws IOException {
		myPlayerView.initialize();
	}

	public void loadGameFile() {
		myGameLocation = myFileSelector.selectFile();
		try {
			myGameData = myDataManager.readGameFile(myGameLocation);
			myProgressSelector = new ProgressSelector(myGameLocation, progressFileName);
			loadGameData();
		} catch (FileNotFoundException e) {
			ErrorPopUp epu = new ErrorPopUp();
			epu.display("File not found", false);
		} catch (NullPointerException e) {
			//User chose not to load a file. No action is needed.
			System.out.println("loaded null");
		}
	}

	private void loadGameData() {
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
			if (c instanceof ButtonPressCondition)
				myButtonConditions.add(c);
		}
	}

	/**
	 * This will save a file with file selector
	 */
	public void saveGameProgress() {
		myProgressSelector.saveProgressState(myGameData);
	}
	
	/**
	 * This will load a file with file selector
	 */
	public void loadGameProgress() {
		myProgressSelector.loadProgressState();
	}
	
	
}
