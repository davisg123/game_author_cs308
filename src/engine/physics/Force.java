package engine.physics;

import java.util.HashMap;
import java.util.Map;

/**
 * class for force, extends vector, super for all forces
 * 
 * @author Ben
 *
 */
public abstract class Force extends Vector {
	protected double myForceValue;
	protected Map<String, Double> myValues;

	public Force(double x, double y) {
		super(x, y);
		calculateForce();
		myValues = new HashMap<String, Double>();
	}

	/**
	 * other constructor, used to solve a problem we had
	 */
	public Force() {
		this(0, 0);
	}

	@Override
	public String toString() {
		return this.getClass().getName();
	}

	public void addOrChangeValue(Scalar cur) {
		myValues.put(cur.toString(), cur.getValue());
		calculateForce();
		calculateMagnitude();
	}

	/**
	 * abstract method that is used in force subclasses to calculate force based
	 * on instance variables
	 * 
	 * @return value of force
	 */
	protected abstract void calculateForce();
}
