package engine.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.collision.objects.CollisionComposition;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public abstract class PhysicsIDAction implements Action, Initializable {

	protected double myValue;
	protected CollisionComposition myCollision;
	protected GameObjectsCollection myGameObjects;
	protected List<Identifier> myID;

	public PhysicsIDAction(List<Identifier> id, double value) {
		myID = id;
		myValue = value;
		myCollision = new CollisionComposition();
	}

	@Override
	public void execute() {
		applyPhysics(myGameObjects);
	}

	@Override
	public void initialize(GameManager manager) {
		for (Identifier id : myID) {
			myGameObjects.add(manager.objectForIdentifier(id));
		}
	}

	public abstract void applyPhysics(GameObjectsCollection myObjects);

	protected void forHelper(GameObjectsCollection myObjects,
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
