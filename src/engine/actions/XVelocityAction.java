package engine.actions;

import engine.gameObject.GameObject;
import engine.physics.Velocity;

public class XVelocityAction extends PhysicsAction{

	public XVelocityAction(GameObject sprite, double value) {
		super(sprite, value);
	}

	@Override
	public void applyPhysics() {
		Velocity a=mySprite.getPhysicsBody().getVelocity();
		Velocity b=new Velocity(myValue, a.getY());
		mySprite.getPhysicsBody().setVelocity(b);
	}

	
}
