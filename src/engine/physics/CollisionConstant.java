package engine.physics;

/**
 * constant for collisions, says if the object is fixed upon collisions or if it
 * moves by the laws of physics
 * 
 * @author Ben
 *
 */
public class CollisionConstant extends Scalar {
	public CollisionConstant(double value) {
		super(value);
	}

	@Override
	protected void initializeForceList() {
		// doesn't do anything with forces, no forces associated with it
	}

}
