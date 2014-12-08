package engine.actions;

import java.util.ArrayList;
import java.util.Collection;

import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.actions.PhysicsIDAction.TwoArgInterface;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Impulse;
import engine.physics.Vector;

public abstract class ImpulseAction extends VectorPhysicsAction {

	public ImpulseAction(ArrayList<Identifier> id, double value) {
		super(id, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(GameManager manager) {
		// TODO Auto-generated method stub

	}

	@Override
	protected TwoArgInterface determineOperation(GameObjectsCollection myObjects,
			Object value) {
		Vector vector = new Vector();
		return (x, y) -> x.getPhysicsBody().addImpulse(
				determineVector((Double) value, vector));
	}
}
