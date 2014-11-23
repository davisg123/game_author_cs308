package engine.physics;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * super for all scalar components, wrapper
 * 
 * @author Ben
 *
 */
public class Scalar extends PhysicsComponent {
	protected double myValue;

	public Scalar(double value) {
		myValue = value;
	}

	/**
	 * getter for value of scalar wrapper
	 * 
	 * @return value of scalar
	 */
	public double getValue() {
		return myValue;
	}

}
