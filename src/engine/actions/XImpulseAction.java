package engine.actions;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Impulse;

public class XImpulseAction extends PhysicsAction {

	public XImpulseAction(Identifier id, double value) {
		super(id, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyPhysics(GameObject... myObjects) {
		TwoArgInterface operation = (x, y) -> x.getPhysicsBody().addImpulse(
				new Impulse((Double) y, 0));
		forHelper(myObjects, operation, myValue);
	}

}
