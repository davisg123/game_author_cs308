package engine.actions.physics;

import java.util.ArrayList;
import java.util.List;

import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Density;
import engine.physics.Scalar;

public class DensityPhysicsAction extends ScalarPhysicsAction {

	public DensityPhysicsAction(ArrayList<Identifier> id, double value) {
		super(id, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Scalar determineScalar(double value, Scalar scalar) {
		scalar = new Density(value);
		return scalar;
	}

}
