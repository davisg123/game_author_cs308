package engine.actions.physics;

import java.util.ArrayList;

import engine.GameManager;
import engine.actions.physics.PhysicsIDAction.TwoArgInterface;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Impulse;
import engine.physics.Vector;

/**
 * 
 * @author Ben
 *
 */
public class YImpulseIDAction extends ImpulseAction {

	public YImpulseIDAction(ArrayList<Identifier> id, Double value) {
		super(id, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Vector determineVector(GameObject object, double value,
			Vector vector) {
		vector = new Impulse(0, value);
		return vector;
	}

}
