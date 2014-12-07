package engine.actions;

import java.util.List;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Impulse;

public class XImpulseIDAction extends PhysicsIDAction {

	public XImpulseIDAction(List<Identifier> ids, double value) {
		super(ids, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyPhysics(GameObject... myObjects) {
		TwoArgInterface operation = (x, y) -> x.getPhysicsBody().addImpulse(
				new Impulse((Double) y, 0));
		forHelper(myObjects, operation, myValue);
	}

}
