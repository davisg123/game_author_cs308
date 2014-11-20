package engine.actions;

import java.util.List;

import engine.physics.Vector;
import engine.physics.Velocity;
import engine.sprite.Sprite;

public class YVelocityAction extends PhysicsAction{

	public YVelocityAction(Sprite sprite, double value) {
		super(sprite, value);
	}

	@Override
	public void applyPhysics() {
		Velocity a=mySprite.getPhysicsBody().getVelocity();
		Velocity b=new Velocity(a.getX(), myValue);
		mySprite.getPhysicsBody().setVelocity(b);
	}


}
