package engine.actions;

import engine.GameManager;
import engine.actions.PhysicsAction.TwoArgInterface;
import engine.gameObject.GameObject;
import engine.physics.Impulse;

public class YImpulseAction extends PhysicsAction {

	public YImpulseAction(GameObject sprite, double value) {
		super(sprite, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(GameManager manager) {
		// TODO Auto-generated method stub

	}

	@Override
	public void applyPhysics(GameObject... myObjects) {
		TwoArgInterface operation = (x, y) -> x.getPhysicsBody().addImpulse(
				new Impulse(0, (Double) y));
		forHelper(myObjects, operation, myValue);
	}

}
