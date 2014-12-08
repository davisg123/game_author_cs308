package engine.physics;

/**
 * Class for the buoyancy force for an object, subclass of force and vector
 * 
 * @author Ben
 *
 */
public class Buoyancy extends Force {
	private static final double GRAVITY_ACCELERATION = 9.8;

	public Buoyancy(double x, double y, Scalar... scalar) {
		super(x, y, scalar);

	}

	/**
	 * calculates force of buoyancy
	 * 
	 * @return the value of the force
	 */
	protected void calculateForce() {
		myForceValue = myValues.get("Density") * GRAVITY_ACCELERATION
				* myValues.get("Volume");
		calculateMagnitude();
	}

	protected void setDefaultValues() {
		if (myValues.get("Density") == null) {
			myValues.put("Density", 1.0);
		}
		if (myValues.get("Volume") == null) {
			myValues.put("Volume", 1.0);
		}
	}

}
