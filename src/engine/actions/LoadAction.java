package engine.actions;

import data.DataManager;
import javafx.stage.FileChooser;
import engine.GameManager;
import gamePlayer.model.DataWrapper;

public class LoadAction implements Action, Initializable{

	GameManager myGameManager; 
	DataManager myDataManager;
	
	@Override
	public void execute() {
		DataWrapper wrapper = myDataManager.readProgressFile();
		myGameManager.load(wrapper); 
	}

	@Override
	public void initialize(GameManager manager) {
		myGameManager=manager;
		myDataManager = new DataManager();
	}

}
