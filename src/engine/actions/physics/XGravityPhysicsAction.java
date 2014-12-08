package engine.actions.physics;

import java.util.ArrayList;

import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Gravity;
import engine.physics.Vector;

/**
 * 
 * @author Ben
 *
 */
public class XGravityPhysicsAction extends ForcePhysicsAction {

	public XGravityPhysicsAction(ArrayList<Identifier> id, Double value) {
		super(id, value);
	}

	@Override
	protected Vector determineVector(GameObject object, double value,
			Vector vector) {
		vector = new Gravity(value, 0.0);
		return vector;
	}

}
