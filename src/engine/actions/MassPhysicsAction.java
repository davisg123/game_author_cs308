package engine.actions;

import java.util.ArrayList;

import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Mass;
import engine.physics.Scalar;

public class MassPhysicsAction extends ScalarPhysicsAction {

	public MassPhysicsAction(ArrayList<Identifier> id, double value) {
		super(id, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Scalar determineScalar(double value, Scalar scalar) {
		scalar = new Mass(value);
		return scalar;
	}

}
