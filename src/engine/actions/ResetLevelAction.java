package engine.actions;

import engine.GameManager;
import engine.level.Level;
import engine.level.LevelManager;

public class ResetLevelAction implements Action, Initializable{

	private transient Level myCurrentLevel; 
	
	@Override
	public void initialize(GameManager manager) {
		
		myCurrentLevel = manager.getLevelManager().getCurrentLevel(); 
		
	}

	@Override
	public void execute() {
		
		myCurrentLevel.resetLevel();
	
	}

	
	
}
