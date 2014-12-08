package engine.actions.physics;

import java.util.ArrayList;
import java.util.Collection;

import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Force;
import engine.physics.Vector;

/**
 * 
 * @author Ben
 *
 */
public abstract class ForcePhysicsAction extends VectorPhysicsAction {

	public ForcePhysicsAction(ArrayList<Identifier> id, Double value) {
		super(id, value);
	}

	@Override
	protected TwoArgInterface determineOperation(
			Collection<GameObject> myObjects, Object value) {
		Vector vector = new Vector();
		return (x, y) -> x.getPhysicsBody().addForce(
				(Force) determineVector(x, (Double) value, vector));
	}

}
