package engine.actions;

import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.collision.objects.CollisionComposition;
import engine.gameObject.GameObject;

public abstract class PhysicsTypeAction implements Action, Initializable{

	protected String myType; 
	protected String mySecondType;
	protected transient CollisionComposition myCollision;
	protected Double myValue;
	protected transient GameObjectsCollection myGameObjects;
	
	public PhysicsTypeAction(String type, String secondType, Double value){
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
