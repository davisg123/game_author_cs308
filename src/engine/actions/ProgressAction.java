package engine.actions;

import data.DataManager;
import engine.GameManager;

public abstract class ProgressAction implements Action, Initializable{

	protected transient GameManager myGameManager;
	protected transient DataManager myDataManager;
	
	
	@Override
	public void initialize(GameManager manager) {
		myGameManager = manager;
		myDataManager = new DataManager();
		
	}

	
	
	
}
