package engine.actions;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.physics.Impulse;

public class XImpulseAction extends PhysicsAction {

	public XImpulseAction(GameObject sprite, double value) {
		super(sprite, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(GameManager manager) {
		// TODO Auto-generated method stub

	}

	@Override
	public void applyPhysics(GameObject[] myObjects) {
		TwoArgInterface operation = (x, y) -> x.getPhysicsBody().addImpulse(
				new Impulse((Double) y, 0));
		forHelper(myObjects, operation, myValue);
	}

}
