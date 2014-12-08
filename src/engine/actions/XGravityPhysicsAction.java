package engine.actions;

import java.util.ArrayList;

import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Gravity;
import engine.physics.Vector;

public class XGravityPhysicsAction extends ForcePhysicsAction {

	public XGravityPhysicsAction(ArrayList<Identifier> id, double value) {
		super(id, value);
	}

	@Override
	protected Vector determineVector(double value, Vector vector) {
		vector = new Gravity(value, 0.0);
		return vector;
	}

}
