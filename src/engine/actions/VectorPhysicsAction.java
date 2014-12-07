package engine.actions;

import engine.gameObject.GameObject;
import engine.physics.Vector;

public abstract class VectorPhysicsAction extends PhysicsComponentAction {

	public VectorPhysicsAction(GameObject sprite, double value) {
		super(sprite, value);
	}

	protected abstract Vector determineVector(double value, Vector vector);

}
