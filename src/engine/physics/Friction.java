package engine.physics;

/**
 * friction force, subclass of force, is a vector
 * 
 * @author Ben
 *
 */
public class Friction extends Force {
	private static final double GRAVITY_ACCELERATION = 9.8;

	public Friction(double x, double y, Scalar... scalar) {
		super(x, y, scalar);
	}

	/**
	 * calculates value of friction force
	 */
	protected void calculateForce() {
		myForceValue = myValues.get("CoefficientOfFriction")
				* myValues.get("Mass") * GRAVITY_ACCELERATION;
	}

	protected void setDefaultValues() {
		if (myValues.get("Mass") == null) {
			myValues.put("Mass", 1.0);
		}
		if (myValues.get("CoefficientOfFriction") == null) {
			myValues.put("CoefficientOfFriction", 0.0);
		}
	}

}
