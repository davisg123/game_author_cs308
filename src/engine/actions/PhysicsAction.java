package engine.actions;

import java.util.Arrays;
import java.util.List;

import engine.GameManager;
import engine.collision.objects.CollisionComposition;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public abstract class PhysicsAction implements Action, Initializable {

	protected Identifier mySpriteID;
	protected Object myValue;
	protected CollisionComposition myCollision;
	protected GameObject myGameObject; 

	public PhysicsAction(Identifier id, Object value) {
		mySpriteID = id;
		myValue = value;
		myCollision = new CollisionComposition();
	}

	@Override
	public void initialize(GameManager myGameManager){
        myGameObject = myGameManager.objectForIdentifier(mySpriteID);
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
