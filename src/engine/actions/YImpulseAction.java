package engine.actions;

import engine.GameManager;
import engine.actions.PhysicsAction.TwoArgInterface;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Impulse;

public class YImpulseAction extends PhysicsAction {

	public YImpulseAction(Identifier id, double value) {
		super(id, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyPhysics(GameObject... myObjects) {
		TwoArgInterface operation = (x, y) -> x.getPhysicsBody().addImpulse(
				new Impulse(0, (Double) y));
		forHelper(myObjects, operation, myValue);
	}

}
