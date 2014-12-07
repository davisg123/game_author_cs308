package engine.actions;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public class ReverseVelocityAction extends PhysicsAction {

	public ReverseVelocityAction(Identifier id, double value) {
		super(id, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyPhysics(GameObject... myObjects) {
		TwoArgInterface operation = (x, y) -> x.getPhysicsBody()
				.reverseVelocity((Boolean) y);
		forHelper(myObjects, operation,
				myCollision.isOnXAxis(myObjects[1], myObjects[2]));
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
