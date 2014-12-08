package engine.actions;

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
public class XFrictionPhysicsAction extends ForcePhysicsAction {

	public XFrictionPhysicsAction(ArrayList<Identifier> id, Double value) {
		super(id, value);
	}

	@Override
	protected Vector determineVector(GameObject object, double value,
			Vector vector) {
		vector = new Friction(value, 0);
		return vector;
	}

}
