package engine.actions;

import java.io.IOException;

import authoring.model.GameData;
import data.DataManager;
import engine.GameManager;
import gamePlayer.model.DataWrapper;

public class SaveAction implements Action, Initializable{

	DataManager myDataManager; 
	GameManager myGameManager; 
	
	@Override
	public void initialize(GameManager manager) {
		// TODO Auto-generated method stub
		myGameManager = manager; 
		myDataManager = new DataManager(); 
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
//		DataWrapper wrapper = myGameManager.getDataWrapper(); 
		GameData data = myGameManager.getGameData(); 
		try {
			myDataManager.writeGameFile(data, "TestFile");
		} catch (IOException e) {
			// TODO NEED TO CHANGE PRINT STACK TRACE LATER
			e.printStackTrace();
		} 
	}

}
