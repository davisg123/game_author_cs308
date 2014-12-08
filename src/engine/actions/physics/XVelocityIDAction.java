package engine.actions.physics;

import java.util.ArrayList;
import java.util.List;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Vector;
import engine.physics.Velocity;

/**
 * 
 * @author Ben
 *
 */

public class XVelocityIDAction extends VelocityIDAction {

	public XVelocityIDAction(ArrayList<Identifier> id, Double value) {
		super(id, value);
	}

	@Override
	protected Vector determineVector(GameObject object, double value,
			Vector vector) {
		vector = new Velocity(value, object.getPhysicsBody().getVelocity()
				.getY());
		return vector;
	}

}
