package engine.actions;

import java.util.Collection;
import java.util.List;

import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Vector;

public abstract class VelocityTypeAction extends VectorPhysicsAction {

	public VelocityTypeAction(List<Identifier> id, Double value) {
		super(id, value);
	}

	@Override
	protected Vector determineVector(GameObject object, double value,
			Vector vector) {
		return null;
	}

	@Override
	protected TwoArgInterface determineOperation(
			Collection<GameObject> myObjects, Object value) {
		return null;
	}

}
