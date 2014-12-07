package engine.actions;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public class FixedCollisionAction extends PhysicsAction{

	public FixedCollisionAction(Identifier id, double value) {
		super(id, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(GameManager manager) {
		// TODO Auto-generated method stub
		
	}

	//important that the fixed one goes in first
	@Override
	public void applyPhysics(GameObject... myObjects) {
		myCollision.fixedCollision(myObjects[0], myObjects[1]);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
