package engine.actions;

import engine.gameObject.GameObject;
import engine.physics.Mass;
import engine.physics.Scalar;

public class MassPhysicsAction extends ScalarPhysicsAction {

	public MassPhysicsAction(GameObject sprite, double value) {
		super(sprite, value);
		// TODO Auto-generated constructor stub
	}

	// unnecessary method in a way, but it makes the structure similar to the
	// vectorphysicsaction hierarchy and it takes some of the work away from
	// other classes. it makes some sense here
	@Override
	protected Scalar determineScalar(double value, Scalar scalar) {
		scalar = new Mass(value);
		return scalar;
	}

	@Override
	protected TwoArgInterface determineOperation(GameObject[] myObjects,
			Object value) {
		// Scalar is abstract and will be overwritten anyway, so for now it's a
		// mass
		Scalar a = new Mass(0);
		return (x, y) -> x.getPhysicsBody().addScalar(
				determineScalar((Double) value, a));
	}

}
