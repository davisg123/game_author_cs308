package engine.physics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * super for all scalar components, wrapper
 * 
 * @author Ben
 *
 */
public abstract class Scalar extends PhysicsComponent implements
		Iterable<String> {
	protected double myValue;
	protected List<String> myAssociatedForces;

	public Scalar(double value) {
		myValue = value;
		myAssociatedForces = new ArrayList<String>();
		initializeForceList();
	}

	/**
	 * getter for value of scalar wrapper
	 * 
	 * @return value of scalar
	 */
	public double getValue() {
		return myValue;
	}

	@Override
	public Iterator<String> iterator() {
		return myAssociatedForces.iterator();
	}

	protected abstract void initializeForceList();
}
