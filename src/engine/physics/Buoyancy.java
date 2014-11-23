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
		super(scalar);
		constructionHelper(x * myForceValue, y * myForceValue);
	}

	/**
	 * calculates force of buoyancy
	 * 
	 * @return the value of the force
	 */
	protected void calculateForce() {
		myForceValue = myValues.get("density") * GRAVITY_ACCELERATION
				* myValues.get("volume");
	}

}
