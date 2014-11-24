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
		myForceValue = myValues.get("Mass") * myValues.get("GravityConstant")
				* GRAVITY_ACCELERATION;
	}

	protected void setDefaultValues() {
		if (myValues.get("Mass") == null) {
			myValues.put("Mass", 1.0);
		}
		if (myValues.get("GravityConstant") == null) {
			myValues.put("GravityConstant", 1.0);
		}
	}
}
