package engine.actions.physics;

import java.util.ArrayList;
import java.util.Collection;

import authoring.model.collections.GameObjectsCollection;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Force;
import engine.physics.Vector;

public abstract class ForcePhysicsAction extends VectorPhysicsAction{

	public ForcePhysicsAction(ArrayList<Identifier> id, double value) {
		super(id, value);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	protected TwoArgInterface determineOperation(GameObjectsCollection myObjects,
			Object value) {
		Vector vector = new Vector();
		return (x,y)->x.getPhysicsBody().addForce((Force) determineVector((Double) value, vector));
	}

}
