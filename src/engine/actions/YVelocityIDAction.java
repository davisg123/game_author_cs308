package engine.actions;

import java.util.List;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Vector;
import engine.physics.Velocity;

/**
 * 
 * @author Ben
 *
 */

public class YVelocityIDAction extends PhysicsIDAction{

	public YVelocityIDAction(List<Identifier> ids, double value) {
		super(ids, value);
	}

	//TODO refactor after discussion about physics
	@Override
	public void applyPhysics() {
		Velocity a=myGameObject.getPhysicsBody().getVelocity();
		Velocity b=new Velocity(a.getX(), myValue);
		myGameObject.getPhysicsBody().setVelocity(b);
	}

	@Override
	public void applyPhysics(GameObject... myObjects) {
		// TODO Auto-generated method stub
		
	}


}
