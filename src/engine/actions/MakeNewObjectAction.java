package engine.actions;

import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;

public abstract class MakeNewObjectAction implements Action, Initializable {

	private GameObjectsCollection myGameObjects; 
	private GameObjectsCollection myMasterList;
	private String myType; 
	
	public MakeNewObjectAction(String type){
		myType = type; 
	}
	
	
	
	@Override
	public void initialize(GameManager manager) {
		
		myMasterList = manager.getLevelManager().getGameObjects(); 
		myGameObjects = manager.getLevelManager().getCurrentLevel().getGameObjectsCollection();
		
	}


}
