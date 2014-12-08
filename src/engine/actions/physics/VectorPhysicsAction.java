package engine.actions.physics;

import java.util.ArrayList;

import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Vector;

public abstract class VectorPhysicsAction extends PhysicsComponentAction {

	public VectorPhysicsAction(ArrayList<Identifier> id, double value) {
		super(id, value);
	}

	protected abstract Vector determineVector(double value, Vector vector);

}
