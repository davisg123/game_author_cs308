package engine.physics;

/**
 * gravity force object
 * 
 * @author Ben
 *
 */
public class Gravity extends Force {
	private static final double GRAVITY_ACCELERATION = 9.8;

	public Gravity(double x, double y, Scalar... scalar) {
		super(scalar);
		constructionHelper(x * myForceValue, y * myForceValue);
	}

	/**
	 * calculates gravitational force
	 */
	@Override
	protected void calculateForce() {
		myForceValue = myValues.get("mass") * myValues.get("gravity constant")
				* GRAVITY_ACCELERATION;
	}

}
