package engine.actions;

import engine.gameObject.GameObject;
import engine.physics.Vector;
import engine.physics.Velocity;

public class XVelocityTypeAction extends VelocityTypeAction{

	public XVelocityTypeAction(String type, Double value) {
		super(type, value);
	}

	@Override
	protected Vector determineVector(GameObject object, double value,
			Vector vector) {
		vector = new Velocity(value, object.getPhysicsBody().getVelocity().getY());
		return vector; 
	}

}
