package engine.actions;

import engine.gameObject.GameObject;
import engine.physics.Scalar;

public abstract class ScalarPhysicsAction extends PhysicsComponentAction {

	public ScalarPhysicsAction(GameObject sprite, double value) {
		super(sprite, value);
		// TODO Auto-generated constructor stub
	}

	protected abstract Scalar determineScalar(double value, Scalar scalar);
}
