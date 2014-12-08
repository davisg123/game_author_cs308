package engine.actions.physics;

import java.util.ArrayList;

import engine.gameObject.Identifier;
import engine.physics.Density;
import engine.physics.Scalar;
import engine.physics.Volume;

public class VolumePhysicsAction extends ScalarPhysicsAction {

	public VolumePhysicsAction(ArrayList<Identifier> id, double value) {
		super(id, value);
	}

	@Override
	protected Scalar determineScalar(double value, Scalar scalar) {
		scalar = new Volume(value);
		return scalar;
	}

}
