package engine.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public class ReverseVelocityIDAction extends PhysicsIDAction {

	public ReverseVelocityIDAction(ArrayList<Identifier> id, double value) {
		super(id, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(GameManager manager) {
		// TODO Auto-generated method stub

	}

	@Override
	public void applyPhysics(Collection<GameObject> myObjects) {
		TwoArgInterface operation = (x, y) -> x.getPhysicsBody()
				.reverseVelocity((Boolean) y);
		List<GameObject> objects=new ArrayList<GameObject>(myObjects);
		forHelper(myObjects, operation,
				myCollision.isOnXAxis(objects.get(0), objects.get(1)));
	}

}
