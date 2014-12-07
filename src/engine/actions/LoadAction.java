package engine.actions;

import authoring.model.GameData;
import data.DataManager;
import javafx.stage.FileChooser;
import engine.GameManager;
import gamePlayer.model.DataWrapper;

/**
 * @author Shreyas
 */

public class LoadAction extends ProgressAction{

	
	@Override
	public void execute() {
		GameData myGameData = myDataManager.readGameFile("Test File");
		myGameManager.load(myGameData);
		
		
	}
}

