package engine.actions;

import java.util.List;

import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Velocity;

/**
 * 
 * @author Ben
 *
 */

public class XVelocityIDAction extends PhysicsIDAction{

	public XVelocityIDAction(List<Identifier> ids, double value) {
		super(ids, value);
	}

	//TODO refactor after physics body discussion
//	@Override
	public void applyPhysics(GameObjectsCollection myGameObjects) {
		Velocity a=(Velocity) myGameObjects.get(0).getPhysicsBody().getVelocity();
		Velocity b=new Velocity(myValue, a.getY());
		myGameObjects.get(0).getPhysicsBody().setVelocity(b);
	}



	
}
