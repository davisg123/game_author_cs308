package engine.actions;

import java.util.ArrayList;

import engine.GameManager;
import engine.actions.PhysicsAction.TwoArgInterface;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Impulse;
import engine.physics.Vector;



public class YImpulseAction extends ImpulseAction {

	public YImpulseAction(ArrayList<Identifier> id, double value) {
		super(id, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(GameManager manager) {
		// TODO Auto-generated method stub

	}

	@Override
	protected Vector determineVector(double value, Vector vector) {
		vector = new Impulse(0, value);
		return vector;
	}

}
