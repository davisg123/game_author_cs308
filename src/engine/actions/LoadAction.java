package engine.actions;

import authoring.model.GameData;
import data.DataManager;
import javafx.stage.FileChooser;
import engine.GameManager;
import gamePlayer.model.DataWrapper;

public class LoadAction implements Action, Initializable{

	GameManager myGameManager; 
	DataManager myDataManager;
	
	@Override
	public void execute() {
		GameData data = myDataManager.readGameFile("TestFile");
		myGameManager.load(data); 
	}

	@Override
	public void initialize(GameManager manager) {
		myGameManager=manager;
		myDataManager = new DataManager();
	}
}
