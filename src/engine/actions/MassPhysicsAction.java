package engine.actions;

import java.util.ArrayList;

import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Mass;
import engine.physics.Scalar;

/**
 * 
 * @author Ben
 *
 */
public class MassPhysicsAction extends ScalarPhysicsAction {

	public MassPhysicsAction(ArrayList<Identifier> id, Double value) {
		super(id, value);
	}

	@Override
	protected Scalar determineScalar(double value, Scalar scalar) {
		scalar = new Mass(value);
		return scalar;
	}

}
