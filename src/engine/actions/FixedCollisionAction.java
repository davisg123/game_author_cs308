package engine.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public class FixedCollisionAction extends PhysicsAction {

	public FixedCollisionAction(ArrayList<Identifier> id, double value) {
		super(id, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(GameManager manager) {
		// TODO Auto-generated method stub

	}

	// important that the fixed one goes in first
	@Override
	public void applyPhysics(Collection<GameObject> myObjects) {
		List<GameObject> objects=new ArrayList<GameObject>(myObjects);
		myCollision.fixedCollision(objects.get(0), objects.get(1));
	}
}
