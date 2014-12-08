package engine.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public class FixedCollisionAction extends PhysicsIDAction{

	public FixedCollisionAction(ArrayList<Identifier> id, double value) {
		super(id, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(GameManager manager) {
		// TODO Auto-generated method stub
		
	}

	//important that the fixed one goes in first
	@Override
	public void applyPhysics(GameObjectsCollection myObjects) {
//		List<GameObject> objects=new ArrayList<GameObject>(myObjects);
		myCollision.fixedCollision(myObjects.get(0), myObjects.get(1));
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
	}

}
