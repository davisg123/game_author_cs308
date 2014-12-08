package engine.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.actions.PhysicsIDAction.TwoArgInterface;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.PhysicsComponent;
import engine.physics.Vector;

public abstract class PhysicsComponentAction extends PhysicsIDAction {

	public PhysicsComponentAction(List<Identifier> ids, double value) {
		super(ids, value);
	}

	@Override
	public void applyPhysics(GameObjectsCollection myObjects) {
		forHelper(myObjects, determineOperation(myObjects, myValue), myValue);
	}

	protected abstract TwoArgInterface determineOperation(
			GameObjectsCollection myObjects, Object value);

}
