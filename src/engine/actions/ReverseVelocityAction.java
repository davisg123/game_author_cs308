package engine.actions;

import java.util.List;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public class ReverseVelocityAction extends PhysicsAction {

	public ReverseVelocityAction(List<Identifier> ids, double value) {
		super(ids, value);
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
