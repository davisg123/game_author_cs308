package engine.actions;

import java.util.ArrayList;
import java.util.Collection;

import engine.GameManager;
import engine.actions.PhysicsAction.TwoArgInterface;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.PhysicsComponent;
import engine.physics.Vector;

public abstract class PhysicsComponentAction extends PhysicsAction {

	public PhysicsComponentAction(ArrayList<Identifier> id, double value) {
		super(id, value);
	}

	@Override
	public void applyPhysics(Collection<GameObject> myObjects) {
		forHelper(myObjects, determineOperation(myObjects, myValue), myValue);
	}

	protected abstract TwoArgInterface determineOperation(
			Collection<GameObject> myObjects, Object value);

}
