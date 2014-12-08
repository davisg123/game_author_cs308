package engine.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public class ReverseVelocityIDAction extends PhysicsIDAction {

	public ReverseVelocityIDAction(List<Identifier> id, double value) {
		super(id, value);
	}

	@Override
	public void initialize(GameManager manager) {
		
		
	}

	@Override
	public void applyPhysics(GameObjectsCollection myGameObjects) {
		TwoArgInterface operation = (x, y) -> x.getPhysicsBody()
				.reverseVelocity((Boolean) y);
		List<GameObject> objects=new ArrayList<GameObject>(myGameObjects);
		forHelper(myGameObjects, operation,
				myCollision.isOnXAxis(objects.get(0), objects.get(1)));
	}

}
