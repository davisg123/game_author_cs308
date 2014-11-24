package engine.physics;

/**
 * class that extends scalar that is a wrapper for the coefficient of friction,
 * assigned to an object's physics body
 * 
 * @author Ben
 *
 */
public class CoefficientOfFriction extends Scalar {

	public CoefficientOfFriction(double value) {
		super(value);
	}

	@Override
	protected void initializeForceList() {
		myAssociatedForces.add("Friction");
	}
}
