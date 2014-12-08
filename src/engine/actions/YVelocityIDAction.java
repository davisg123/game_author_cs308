package engine.actions;

import java.util.List;

import authoring.model.collections.GameObjectsCollection;
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
	public void applyPhysics(GameObjectsCollection myGameObjects) {
		Velocity a=(Velocity) myGameObjects.get(0).getPhysicsBody().getVelocity();
		Velocity b=new Velocity(a.getX(), myValue);
		myGameObjects.get(0).getPhysicsBody().setVelocity(b);
	}




}
