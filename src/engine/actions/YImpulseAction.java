package engine.actions;

import java.util.List;

import engine.GameManager;
import engine.actions.PhysicsAction.TwoArgInterface;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Impulse;

public class YImpulseAction extends PhysicsAction {

	public YImpulseAction(List<Identifier> ids, double value) {
		super(ids, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyPhysics(GameObject... myObjects) {
		TwoArgInterface operation = (x, y) -> x.getPhysicsBody().addImpulse(
				new Impulse(0, (Double) y));
		forHelper(myObjects, operation, myValue);
	}

}
