package engine.actions;

import java.util.List;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Velocity;

/**
 * 
 * @author Ben
 *
 */

public class XVelocityAction extends PhysicsAction{

	public XVelocityAction(List<Identifier> ids, double value) {
		super(ids, value);
	}

	//TODO refactor after physics body discussion
	@Override
	public void applyPhysics() {
		Velocity a=myGameObject.getPhysicsBody().getVelocity();
		Velocity b=new Velocity(myValue, a.getY());
		myGameObject.getPhysicsBody().setVelocity(b);
	}

	
}
