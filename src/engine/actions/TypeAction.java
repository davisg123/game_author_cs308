package engine.actions;

import engine.GameManager;
import engine.level.Level;

public abstract class TypeAction implements Action, Initializable{

	protected transient Level myCurrentLevel; 
	protected String myType; 
	
	public TypeAction(String type){
		myType = type; 
	}
	
	@Override
	public void initialize(GameManager manager) {
		myCurrentLevel = manager.getLevelManager().getCurrentLevel();
		
	}



}
