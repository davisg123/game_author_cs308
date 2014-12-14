package engine.actions;

import engine.GameManager;
import engine.level.Level;
import engine.level.LevelManager;

public class ResetLevelAction implements Action, Initializable{

	private GameManager myManager;
	
	@Override
	public void initialize(GameManager manager) {
		myManager = manager;
	}

	@Override
	public void execute() {
		myManager.getLevelManager().initializeCurrentLevel();
	}

	
	
}
