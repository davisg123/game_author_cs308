package engine.physics;

/**
 * mass constant
 * 
 * @author Ben
 *
 */
public class Mass extends Scalar {
	public Mass(double value) {
		super(value);
	}

	public static void main(String[] args) {
		Mass a = new Mass(2.0);
		System.out.println(a.toString());
	}
}
