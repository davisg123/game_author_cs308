package engine.actions;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.physics.Impulse;
import engine.physics.Vector;

public class XImpulseAction extends ImpulseAction {

	public XImpulseAction(GameObject sprite, double value) {
		super(sprite, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(GameManager manager) {
		// TODO Auto-generated method stub

	}

	@Override
	protected Vector determineVector(double value, Vector vector) {
		// doing this for a reason. Now it's vector and impulse
		vector = new Impulse(value, 0.0);
		return vector;
	}

}
