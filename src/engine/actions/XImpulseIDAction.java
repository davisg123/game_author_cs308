package engine.actions;

import java.util.ArrayList;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Impulse;
import engine.physics.Vector;

public class XImpulseIDAction extends ImpulseAction {

	public XImpulseIDAction(ArrayList<Identifier> id, double value) {
		super(id, value);
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
