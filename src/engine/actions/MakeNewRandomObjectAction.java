package engine.actions;

import java.util.Random;

import engine.gameObject.GameObject;

public class MakeNewRandomObjectAction extends MakeNewObjectAction{

	protected Random r; 
	protected Double myLowerXBound;
	protected Double myUpperXBound;
	protected Double myLowerYBound;
	protected Double myUpperYBound; 
	
	public MakeNewRandomObjectAction(String type, Double lowerXBound, Double upperXBound, Double lowerYBound, Double upperYBound){
		super(type); 
		r = new Random(); 
		myLowerXBound = lowerXBound;
		myLowerYBound = lowerYBound;
		myUpperXBound = upperXBound;
		myUpperYBound = upperYBound;

	}

	
	
	@Override
	public void execute() {
		for (GameObject object: myMasterList){
			//TODO: make this a template list
			if (object.getIdentifier().getType().equals(myType)){
				makeRandomObject(object);
				
			}
		}
		
	}
	
	public void makeRandomObject(GameObject object){
            double x =  (myUpperXBound-myLowerXBound) * r.nextFloat() + myLowerXBound; 
            double y =  (myUpperYBound-myLowerYBound) * r.nextFloat() + myLowerYBound; 
            GameObject newObject = new GameObject(object, x, y, myType); 
		newObject.setIdentifier(object.getIdentifier());
		newObject.setPhysicsBody(object.getPhysicsBody());
		myRenderer.createAndAssignRenderedNode(newObject);
		myCurrentLevel.addGameObject(newObject);
	}
}
