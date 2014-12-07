package engine.actions;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.physics.Vector;

public abstract class VectorPhysicsAction extends PhysicsAction{

	protected 
	public VectorPhysicsAction(GameObject sprite, double value) {
		super(sprite, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(GameManager manager) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void applyPhysics(GameObject... myObjects) {
		
	}
	
	protected abstract Vector determineVector(double value);

	
}
