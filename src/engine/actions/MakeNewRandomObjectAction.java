package engine.actions;

import java.util.Random;

import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.gameObject.components.PhysicsBody;

public class MakeNewRandomObjectAction extends MakeNewObjectAction{

	protected Double myLowerXBound;
	protected Double myUpperXBound;
	protected Double myLowerYBound;
	protected Double myUpperYBound; 
	
	public MakeNewRandomObjectAction(String type, Double lowerXBound, Double upperXBound, Double lowerYBound, Double upperYBound){
		super(type); 
		myLowerXBound = lowerXBound;
		myLowerYBound = lowerYBound;
		myUpperXBound = upperXBound;
		myUpperYBound = upperYBound;

	}

	
	
	@Override
	public void execute() {
		for (GameObject object: myMasterList){
			if (object.getIdentifier().getType().equals(myType)){
				makeRandomObject(object);
			}
		}
		
	}
	
	public void makeRandomObject(GameObject object){
            double x =  (myUpperXBound-myLowerXBound) * r.nextFloat() + myLowerXBound; 
            double y =  (myUpperYBound-myLowerYBound) * r.nextFloat() + myLowerYBound; 
            GameObject newObject = new GameObject(object, x, y, myType); 
		newObject.setIdentifier(new Identifier(object.getIdentifier()));
		newObject.setPhysicsBody(new PhysicsBody(object.getPhysicsBody()));
		myRenderer.createAndAssignRenderedNode(newObject);
		myCurrentLevel.getGameObjectsCollection().add(newObject);
	}
}
