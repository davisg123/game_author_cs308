package engine.actions;

import java.util.Arrays;
import java.util.List;

import engine.collision.objects.CollisionComposition;
import engine.gameObject.GameObject;

public abstract class PhysicsAction implements Action, Initializable {

	protected GameObject mySprite;
	protected Object myValue;
	protected CollisionComposition myCollision;

	public PhysicsAction(GameObject sprite, Object value) {
		mySprite = sprite;
		myValue = value;
		myCollision = new CollisionComposition();
	}

	@Override
	public void execute() {
		// applyPhysics();
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
