package engine.actions;

import engine.GameManager;
import engine.level.LevelManager;

public class ChangeLevelAction implements Action, Initializable{

	LevelManager myLevelManager; 
	String myID; 
	
	public ChangeLevelAction(String id){
		myID=id; 
	}
	
	@Override
	public void initialize(GameManager gamemanager) {
		myLevelManager=gamemanager.getLevelManager();
		
	}

	@Override
	public void execute() {
		myLevelManager.changeLevel(myID);
	}
}
