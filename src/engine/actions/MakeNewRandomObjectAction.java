package engine.actions;

import java.util.Random;

import engine.gameObject.GameObject;

public class MakeNewRandomObjectAction extends MakeNewObjectAction{

	protected Random r; 
	protected double myLowerXBound;
	protected double myUpperXBound;
	protected double myLowerYBound;
	protected double myUpperYBound; 
	
	public MakeNewRandomObjectAction(String type, double lowerXBound, double upperXBound, double lowerYBound, double upperYBound){
		super(type); 
		r = new Random(); 
		
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
		double x = r.nextInt((int) (myUpperXBound-myLowerXBound)) + myLowerXBound; 
		double y = r.nextInt((int) (myUpperYBound-myLowerYBound)) + myLowerYBound; 
		GameObject newObject = new GameObject(object, x, y, myType); 
		newObject.setIdentifier(object.getIdentifier());
		newObject.setPhysicsBody(object.getPhysicsBody());
		myRenderer.createAndAssignRenderedNode(newObject);
		myCurrentLevel.addGameObject(newObject);
	}
}
