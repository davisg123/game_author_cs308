package engine.physics;

/**
 * Subclass of Vector, is a vector representation of an object's acceleration
 * 
 * @author Ben
 *
 */
public class Acceleration extends Vector {
	public Acceleration(double x, double y) {
		super(x, y);
	}

	public Acceleration() {
		super(0, 0);
	}
}
