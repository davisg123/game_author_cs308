package engine.actions;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.physics.Impulse;
import engine.physics.Vector;

public class XImpulseAction extends VectorPhysicsAction {

	public XImpulseAction(GameObject sprite, double value) {
		super(sprite, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(GameManager manager) {
		// TODO Auto-generated method stub

	}

	// not using composition because it would then get too specific-vector based
	// ones get this composition thing, others don't...
	@Override
	protected Vector determineVector(double value) {
		Vector toReturn=new Impulse(value,0.0);
		return toReturn;
	}

}
