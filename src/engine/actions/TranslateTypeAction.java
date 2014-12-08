package engine.actions;

import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.gameObject.GameObject;

public abstract class TranslateTypeAction implements Action, Initializable{

	protected GameObjectsCollection myGameObjects; 
	protected String myType; 
	protected Double myValue;
	
	public TranslateTypeAction(String type, Double value){
		myType = type; 
		myValue = value; 
	}
	
	
	@Override
	public void initialize(GameManager manager) {
		myGameObjects = manager.getLevelManager().getCurrentLevel().getGameObjectsCollection(); 
		
	}


}
