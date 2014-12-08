package engine.actions.physics;

import java.util.ArrayList;

import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Friction;
import engine.physics.Vector;

public class XFrictionPhysicsAction extends ForcePhysicsAction {

	public XFrictionPhysicsAction(ArrayList<Identifier> id, double value) {
		super(id, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Vector determineVector(double value, Vector vector) {
		vector = new Friction(value, 0);
		return vector;
	}

}
