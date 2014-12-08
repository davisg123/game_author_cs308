package engine.actions.levelinteractions;

import engine.GameManager;
import engine.actions.Action;
import engine.actions.Initializable;
import engine.gameObject.Identifier;
import engine.level.LevelManager;

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
