package engine.actions;

import engine.GameManager;
import engine.actions.PhysicsAction.TwoArgInterface;
import engine.gameObject.GameObject;
import engine.physics.Impulse;
import engine.physics.Vector;

public abstract class ImpulseAction extends VectorPhysicsAction {

	public ImpulseAction(GameObject sprite, double value) {
		super(sprite, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(GameManager manager) {
		// TODO Auto-generated method stub

	}

	@Override
	protected TwoArgInterface determineOperation(GameObject[] myObjects,
			Object value) {
		Vector vector = new Vector();
		return (x, y) -> x.getPhysicsBody().addImpulse(
				determineVector((Double) value, vector));
	}
}
