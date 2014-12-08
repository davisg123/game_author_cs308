package engine.actions.physics;

import java.util.ArrayList;

import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Friction;
import engine.physics.Vector;

/**
 * 
 * @author Ben
 *
 */
public class YFrictionPhysicsAction extends ForcePhysicsAction {

	public YFrictionPhysicsAction(ArrayList<Identifier> id, Double value) {
		super(id, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Vector determineVector(GameObject object, double value,
			Vector vector) {
		vector = new Friction(0, value);
		return vector;
	}

}
