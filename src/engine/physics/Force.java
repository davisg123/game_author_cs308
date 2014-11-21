package engine.physics;

/**
 * class for force, extends vector, super for all forces
 * 
 * @author Ben
 *
 */
public abstract class Force extends Vector {
	protected double myForceValue;

	public Force(double x, double y) {
		super(x, y);
		myForceValue = calculateForce();
	}

	/**
	 * other constructor, used to solve a problem we had
	 */
	public Force() {
		this(0, 0);
	}

	/**
	 * abstract method that is used in force subclasses to calculate force based
	 * on instance variables
	 * 
	 * @return value of force
	 */
	protected abstract double calculateForce();
}
