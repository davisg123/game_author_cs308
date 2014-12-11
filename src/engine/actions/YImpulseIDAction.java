package engine.actions;

import java.util.ArrayList;
import java.util.List;
import engine.GameManager;
import engine.actions.PhysicsIDAction.TwoArgInterface;
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

	public YImpulseIDAction(List<Identifier> id, Double value) {
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
