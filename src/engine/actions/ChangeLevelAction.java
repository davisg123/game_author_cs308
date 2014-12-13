package engine.actions;

import engine.GameManager;
import engine.gameObject.Identifier;
import engine.level.LevelManager;

public class ChangeLevelAction implements Action, Initializable{

	private Identifier levelID; 
	private transient LevelManager myLevelManager;
	
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
