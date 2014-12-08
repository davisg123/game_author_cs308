package engine.actions.physics;

import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.actions.Action;
import engine.actions.Initializable;
import engine.gameObject.GameObject;

public abstract class PhysicsTypeAction implements Action, Initializable{

	protected String myType; 
	protected double myValue;
	protected GameObjectsCollection myGameObjects;
	
	public PhysicsTypeAction(String type, double value){
		myType=type;
		myValue=value; 
	}
	
	@Override
	public void initialize(GameManager manager) {
		myGameObjects = manager.getLevelManager().getCurrentLevel().getGameObjectsCollection();
	}

	@Override
	public void execute(){
		//applyPhysics(); 
	}
	
	public abstract void applyPhysics(GameObject... myObjects);


}
