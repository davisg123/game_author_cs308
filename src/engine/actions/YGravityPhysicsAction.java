package engine.actions;

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
public class YGravityPhysicsAction extends ForcePhysicsAction {

	public YGravityPhysicsAction(ArrayList<Identifier> id, Double value) {
		super(id, value);
	}

	@Override
	protected Vector determineVector(GameObject object, double value,
			Vector vector) {
		vector = new Gravity(0, value);
		return vector;
	}

}
