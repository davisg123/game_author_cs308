package engine.actions;

import java.util.ArrayList;

import engine.gameObject.Identifier;
import engine.physics.Density;
import engine.physics.Scalar;
import engine.physics.Volume;

/**
 * 
 * @author Ben
 *
 */
public class VolumePhysicsAction extends ScalarPhysicsAction {

	public VolumePhysicsAction(ArrayList<Identifier> id, Double value) {
		super(id, value);
	}

	@Override
	protected Scalar determineScalar(double value, Scalar scalar) {
		scalar = new Volume(value);
		return scalar;
	}

}
