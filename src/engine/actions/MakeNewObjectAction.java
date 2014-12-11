package engine.actions;

import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.level.Level;
import engine.render.GameObjectRenderer;

public abstract class MakeNewObjectAction implements Action, Initializable {

	protected Level myCurrentLevel; 
	protected GameObjectsCollection myMasterList;
	protected transient GameObjectRenderer myRenderer; 
	protected String myType; 
	
	public MakeNewObjectAction(String type){
		myType = type; 
	}
	
	
	
	@Override
	public void initialize(GameManager manager) {
		myRenderer = manager.getRenderer();
		//will be template list
		myMasterList = manager.getLevelManager().getTemplates(); 
		myCurrentLevel = manager.getLevelManager().getCurrentLevel();
		
	}


}
