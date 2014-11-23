package engine.physics;

import java.util.ArrayList;

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

	@Override
	protected void initializeForceList() {
		myAssociatedForces.add("Gravity");
		myAssociatedForces.add("Friction");
	}

}
