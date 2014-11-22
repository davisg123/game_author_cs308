package engine.physics;

/**
 * Class for the buoyancy force for an object, subclass of force and vector
 * 
 * @author Ben
 *
 */
public class Buoyancy extends Force {
	private static final double GRAVITY_ACCELERATION = 9.8;
	private double volume;
	private double densityOfFluid;

	public Buoyancy(double x, double y, double volume, double density) {
		super();
		this.volume = volume;
		this.densityOfFluid = density;
		constructionHelper(x * myForceValue, y * myForceValue);
	}
	/**
	 * calculates force of buoyancy
	 * @return the value of the force
	 */
	protected double calculateForce() {
		return densityOfFluid * GRAVITY_ACCELERATION * volume;
	}
}
