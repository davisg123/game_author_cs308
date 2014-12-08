package engine.actions.physics;

import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.actions.Action;
import engine.actions.Initializable;
import engine.collision.objects.CollisionComposition;
import engine.gameObject.GameObject;

public abstract class PhysicsTypeAction implements Action, Initializable{

	protected String myType; 
	protected String mySecondType;
	protected CollisionComposition myCollision;
	protected double myValue;
	protected GameObjectsCollection myGameObjects;
	
	public PhysicsTypeAction(String type, String secondType, double value){
		myType=type;
		mySecondType = secondType;
		myValue=value; 
		myCollision = new CollisionComposition();
	}
	
	@Override
	public void initialize(GameManager manager) {
		myGameObjects = manager.getLevelManager().getCurrentLevel().getGameObjectsCollection();
	}

	@Override
	public void execute(){
		applyPhysics(myGameObjects); 
	}
	
	public abstract void applyPhysics(GameObjectsCollection myObjects);


}
