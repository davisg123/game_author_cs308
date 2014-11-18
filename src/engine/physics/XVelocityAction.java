package engine.physics;

import engine.actions.PhysicsAction;
import engine.sprite.Sprite;

public class XVelocityAction extends PhysicsAction{

	public XVelocityAction(Sprite sprite, double value) {
		super(sprite, value);
	}

	@Override
	public void applyPhysics() {
		Velocity a=mySprite.getPhysicsBody().getVelocity();
		Velocity b=new Velocity(myValue, a.getY());
		mySprite.getPhysicsBody().setVelocity(b);
	}

	
}
