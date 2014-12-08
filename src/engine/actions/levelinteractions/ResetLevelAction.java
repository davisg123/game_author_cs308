package engine.actions.levelinteractions;

import engine.GameManager;
import engine.actions.Action;
import engine.actions.Initializable;
import engine.level.Level;
import engine.level.LevelManager;

public class ResetLevelAction implements Action, Initializable{

	private Level myCurrentLevel; 
	
	@Override
	public void initialize(GameManager manager) {
		
		myCurrentLevel = manager.getLevelManager().getCurrentLevel(); 
		
	}

	@Override
	public void execute() {
		
		myCurrentLevel.resetLevel();
	
	}

	
	
}
