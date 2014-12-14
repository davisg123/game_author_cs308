package engine.actions;

import engine.gameObject.GameObject;
import engine.physics.Vector;
import engine.physics.Velocity;

public class YVelocityTypeAction extends VelocityTypeAction {

	public YVelocityTypeAction(String type, Double value) {
		super(type, value);
	}

	@Override
	protected Vector determineVector(GameObject object, double value,
			Vector vector) {
		vector = new Velocity(object.getPhysicsBody().getVelocity().getX(),
				value);
		return vector; 
	}
	
	

}
