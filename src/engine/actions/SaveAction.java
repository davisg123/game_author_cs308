package engine.actions;

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
		DataWrapper wrapper = myGameManager.getDataWrapper(); 
		myDataManager.writeProgressFile(wrapper); 
	}

}
