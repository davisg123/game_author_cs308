package engine.actions;

import engine.GameManager;
import engine.actions.PhysicsAction.TwoArgInterface;
import engine.gameObject.GameObject;
import engine.physics.PhysicsComponent;
import engine.physics.Vector;

public abstract class PhysicsComponentAction extends PhysicsAction {

	public PhysicsComponentAction(GameObject sprite, double value) {
		super(sprite, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(GameManager manager) {
		// TODO Auto-generated method stub

	}

	@Override
	public void applyPhysics(GameObject... myObjects) {
		forHelper(myObjects, determineOperation(myObjects, myValue), myValue);
	}


	protected abstract TwoArgInterface determineOperation(
			GameObject[] myObjects, Object value);

}
