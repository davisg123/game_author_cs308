package engine.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import authoring.model.collections.GameObjectsCollection;
import engine.actions.PhysicsIDAction.TwoArgInterface;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Vector;

public abstract class VelocityTypeAction extends TypeAction{

	protected Double myValue;
	
	public VelocityTypeAction(String type, Double value) {
		super(type);
		myValue = value; 

	}

	@Override
	public void execute(){
		Collection<GameObject> objectsOfType = new ArrayList<GameObject>();
		for (GameObject object: myCurrentLevel.getGameObjectsCollection()){
			if (object.getIdentifier().getType().equals(myType)){
				objectsOfType.add(object);
			}
		}
		applyPhysics(objectsOfType);
		
	}
	
	public void applyPhysics(Collection<GameObject> myObjects) {
		forHelper(myObjects, determineOperation(myObjects, myValue), myValue);
	}
	
	protected TwoArgInterface determineOperation(
			Collection<GameObject> myObjects, Object value) {
		Vector vector = new Vector();
		return (x, y) -> x.getPhysicsBody().setVelocity(
				determineVector(x, (Double) value, vector));
	}
	
	protected abstract Vector determineVector(GameObject object, double value,
			Vector vector);

	protected void forHelper(Collection<GameObject> myObjects,
			TwoArgInterface myOperation, Object value) {
		myObjects.forEach(x -> myOperation.operation(x, value));
	}

	protected interface TwoArgInterface {
		public void operation(GameObject x, Object a);
	}


	
}
