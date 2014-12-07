package engine.actions;

import engine.gameObject.GameObject;
import engine.physics.Density;
import engine.physics.Scalar;

public class DensityPhysicsAction extends ScalarPhysicsAction {

	public DensityPhysicsAction(GameObject sprite, double value) {
		super(sprite, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Scalar determineScalar(double value, Scalar scalar) {
		scalar = new Density(value);
		return scalar;
	}

}
