package engine.actions.levelinteractions;

import data.DataManager;
import engine.GameManager;
import engine.actions.Action;
import engine.actions.Initializable;

public abstract class ProgressAction implements Action, Initializable{

	protected GameManager myGameManager;
	protected DataManager myDataManager;
	
	
	@Override
	public void initialize(GameManager manager) {
		myGameManager = manager;
		myDataManager = new DataManager();
		
	}

	
	
	
}
