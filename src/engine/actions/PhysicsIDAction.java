package engine.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import engine.GameManager;
import engine.collision.objects.CollisionComposition;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public abstract class PhysicsIDAction implements Action, Initializable {

	protected double myValue;
	protected CollisionComposition myCollision;
	protected Collection<GameObject> myObjects;
	protected List<Identifier> myID;

	public PhysicsIDAction(ArrayList<Identifier> id, double value) {
		myID = id;
		myValue = value;
		myCollision = new CollisionComposition();
		myObjects = new ArrayList<GameObject>();
	}

	@Override
	public void execute() {
		applyPhysics(myObjects);
	}

	public void initialize(GameManager manager) {
		for (Identifier id : myID) {
			myObjects.add(manager.objectForIdentifier(id));
		}
	}

	public abstract void applyPhysics(Collection<GameObject> myObjects);

	protected void forHelper(Collection<GameObject> myObjects,
			TwoArgInterface myOperation, Object value) {
		myObjects.forEach(x -> myOperation.operation(x, value));
	}

	protected interface TwoArgInterface {
		public void operation(GameObject x, Object a);
	}

	protected interface ThreeArgInterface {
		public void operation(GameObject x, GameObject y, boolean bool);
	}
}
