package engine.actions;

import java.util.ArrayList;
import java.util.List;

import engine.gameObject.Identifier;
import engine.physics.Density;
import engine.physics.Scalar;
import engine.physics.Volume;

public class VolumePhysicsAction extends ScalarPhysicsAction {

	public VolumePhysicsAction(List<Identifier> ids, double value) {
		super(ids, value);
	}

	@Override
	protected Scalar determineScalar(double value, Scalar scalar) {
		scalar = new Volume(value);
		return scalar;
	}

}
