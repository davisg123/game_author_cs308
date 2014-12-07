package engine.actions;

import engine.GameManager;
import engine.gameObject.GameObject;

public class ReverseVelocityAction extends PhysicsAction {

	public ReverseVelocityAction(GameObject sprite, double value) {
		super(sprite, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(GameManager manager) {
		// TODO Auto-generated method stub

	}

	@Override
	public void applyPhysics(GameObject[] myObjects) {
		TwoArgInterface operation = (x, y) -> x.getPhysicsBody()
				.reverseVelocity((Boolean) y);
		forHelper(myObjects, operation,
				myCollision.isOnXAxis(myObjects[1], myObjects[2]));
	}

}
