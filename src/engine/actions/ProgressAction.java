package engine.actions;

import data.DataManager;
import engine.GameManager;

public abstract class ProgressAction implements Action, Initializable{

	protected GameManager myGameManager;
	protected DataManager myDataManager;
	
	
	@Override
	public void initialize(GameManager manager) {
		myGameManager = manager;
		myDataManager = new DataManager();
		
	}

	
	
	
}
