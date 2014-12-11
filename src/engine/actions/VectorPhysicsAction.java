package engine.actions;

import java.util.ArrayList;
import java.util.List;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Vector;

/**
 * 
 * @author Ben
 *
 */
public abstract class VectorPhysicsAction extends PhysicsComponentAction {

	public VectorPhysicsAction(List<Identifier> id, Double value) {
		super(id, value);
	}

	/*
	 * this method, along with determineScalar, could have been written
	 * elsewhere and I could have gotten rid of vector/scalar trees and combined
	 * them into one; however, i wasn't sure if i was going to keep physics
	 * component, since code-wise it doesn't help but geometrically i like it.
	 * in the future, it might help as well
	 */
	protected abstract Vector determineVector(GameObject object, double value,
			Vector vector);

}
