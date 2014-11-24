package engine.actions;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.physics.Velocity;

/**
 * 
 * @author Ben
 *
 */

public class XVelocityAction extends PhysicsAction{

	public XVelocityAction(GameObject sprite, double value) {
		super(sprite, value);
	}

	//TODO refactor after physics body discussion
	@Override
	public void applyPhysics() {
		Velocity a=mySprite.getPhysicsBody().getVelocity();
		Velocity b=new Velocity(myValue, a.getY());
		mySprite.getPhysicsBody().setVelocity(b);
	}

	@Override
	public void initialize(GameManager manager) {
		// TODO Auto-generated method stub
		
	}

	
}
