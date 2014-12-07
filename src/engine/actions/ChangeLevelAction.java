package engine.actions;

import engine.GameManager;
import engine.gameObject.Identifier;
import engine.level.LevelManager;

/**
 * @author Shreyas
 */

public class ChangeLevelAction implements Action, Initializable{

	Identifier levelID; 
	LevelManager myLevelManager;
	
	public ChangeLevelAction(Identifier id){
		levelID=id; 
	}
	
	@Override
	public void initialize(GameManager gameManager) {
		myLevelManager = gameManager.getLevelManager();
	}

	@Override
	public void execute() {
		myLevelManager.changeToLevel(levelID);
	}
}
