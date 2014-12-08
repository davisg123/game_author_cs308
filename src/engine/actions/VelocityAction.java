package engine.actions;

import java.util.List;

import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public abstract class VelocityAction extends PhysicsIDAction{

	public VelocityAction(List<Identifier> ids, double value) {
		super(ids, value);
	}

	@Override
	public void initialize(GameManager manager) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void applyPhysics(GameObjectsCollection myGameObjects) {
		
	}
	
}
