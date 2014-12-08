package engine.actions;

import java.util.ArrayList;
import java.util.Collection;

import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Vector;

public abstract class ForcePhysicsAction extends VectorPhysicsAction{

	public ForcePhysicsAction(ArrayList<Identifier> id, double value) {
		super(id, value);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	protected TwoArgInterface determineOperation(Collection<GameObject> myObjects,
			Object value) {
		Vector vector = new Vector();
		return (x,y)->x.getPhysicsBody().addForce(determineVector((Double) value, vector));
	}

}
