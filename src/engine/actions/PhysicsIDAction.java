package engine.actions;

import java.util.Arrays;
import java.util.List;

import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.collision.objects.CollisionComposition;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public abstract class PhysicsIDAction implements Action, Initializable {

	protected List<Identifier> myGameObjectIDs;
	protected double myValue;
	protected CollisionComposition myCollision;
	protected GameObjectsCollection myGameObjects; 

	public PhysicsIDAction(List<Identifier> ids, double value) {
		myGameObjectIDs = ids;
		myValue = value;
		myCollision = new CollisionComposition();
	}

	@Override
	public void initialize(GameManager myGameManager){
		for (Identifier id: myGameObjectIDs){
			myGameObjects.add(myGameManager.objectForIdentifier(id));
		}
	}
	
	@Override
	public void execute() {
		//applyPhysics();
	}

	public abstract void applyPhysics(GameObject... myObjects);

	protected void forHelper(GameObject[] myObjects,
			TwoArgInterface myOperation, Object value) {
		Arrays.asList(myObjects).forEach(x -> myOperation.operation(x, value));
	}

	protected interface TwoArgInterface {
		public void operation(GameObject x, Object a);
	}

	protected interface ThreeArgInterface {
		public void operation(GameObject x, GameObject y, boolean bool);
	}
}
