package engine.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public class FixedCollisionAction extends PhysicsIDAction {
	/**
	 * 
	 * @param id
	 *            is the list of ids
	 * @param value
	 *            is the value to change potentiall
	 * @author Ben
	 */
	public FixedCollisionAction(ArrayList<Identifier> id, Double value) {
		super(id, value);
	}

	@Override
	public void applyPhysics(Collection<GameObject> myObjects) {
		List<GameObject> objects = new ArrayList<GameObject>(myObjects);
		myCollision.fixedCollision(objects.get(0), objects.get(1));
	}

}
