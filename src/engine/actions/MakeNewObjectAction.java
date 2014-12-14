package engine.actions;

import java.util.Random;

import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.level.Level;
import engine.render.GameObjectRenderer;

public abstract class MakeNewObjectAction implements Action, Initializable {

	protected transient Level myCurrentLevel; 
	protected transient GameObjectsCollection myMasterList;
	protected transient GameObjectRenderer myRenderer; 
	protected String myType; 
	protected transient Random r;

	
	public MakeNewObjectAction(String type){
		myType = type; 
	}
	
	
	
	@Override
	public void initialize(GameManager manager) {
		myRenderer = manager.getRenderer();
		r = new Random();
		//will be template list
		myMasterList = manager.getLevelManager().getTemplates(); 
		myCurrentLevel = manager.getLevelManager().getCurrentLevel();
		
	}


}
