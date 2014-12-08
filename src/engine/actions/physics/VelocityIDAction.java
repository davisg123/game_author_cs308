package engine.actions.physics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import engine.GameManager;
import engine.actions.physics.PhysicsIDAction.TwoArgInterface;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Vector;

public abstract class VelocityIDAction extends VectorPhysicsAction {

	public VelocityIDAction(ArrayList<Identifier> id, double value) {
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
