package engine.actions;

import engine.GameManager;
import engine.gameObject.GameObject;

public class FixedCollisionAction extends PhysicsAction{

	public FixedCollisionAction(GameObject sprite, double value) {
		super(sprite, value);
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

}
