package engine.actions;

import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.gameObject.GameObject;
import engine.level.Level;

public abstract class TranslateTypeAction implements Action, Initializable{

	protected GameObjectsCollection myGameObjects; 
	protected Level myCurrentLevel;
	protected String myType; 
	protected double myValue;
	
	public TranslateTypeAction(String type, double value){
		myType = type; 
		myValue = value; 
	}
	
	
	@Override
	public void initialize(GameManager manager) {
	    myCurrentLevel = manager.getLevelManager().getCurrentLevel(); 
	}


}
