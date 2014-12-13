package engine.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import engine.GameManager;
import engine.actions.PhysicsIDAction.TwoArgInterface;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Vector;

/**
 * 
 * @author Ben
 *
 */
public abstract class VelocityIDAction extends VectorPhysicsAction {

	public VelocityIDAction(List<Identifier> id, Double value) {
		super(id, value);
	}

	@Override
	protected TwoArgInterface determineOperation(
			Collection<GameObject> myObjects, Object value) {
		Vector vector = new Vector();
		return (x, y) -> x.getPhysicsBody().setVelocity(
				determineVector(x, (Double) value, vector));
	}

}
