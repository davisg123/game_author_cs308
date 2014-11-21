package engine.actions;

import java.util.List;
import engine.gameObject.GameObject;
import engine.physics.Vector;
import engine.physics.Velocity;

public class YVelocityAction extends PhysicsAction{

	public YVelocityAction(GameObject sprite, double value) {
		super(sprite, value);
	}

	@Override
	public void applyPhysics() {
		Velocity a=mySprite.getPhysicsBody().getVelocity();
		Velocity b=new Velocity(a.getX(), myValue);
		mySprite.getPhysicsBody().setVelocity(b);
	}


}
