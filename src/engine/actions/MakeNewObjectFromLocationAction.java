package engine.actions;

import authoring.model.collections.GameObjectsCollection;
import engine.gameObject.GameObject;

public class MakeNewObjectFromLocationAction extends MakeNewObjectAction{

	private double myX; 
	private double myY; 
	
	public MakeNewObjectFromLocationAction(String type, double x, double y) {
		super(type);
		myX = x; 
		myX = y; 
		
	}

	@Override
	public void execute() {
		for (GameObject object: myMasterList){
		    System.out.println(object.getIdentifier().getHash());
			//TODO: will be template list
			if (object.getIdentifier().getType().equals(myType)){
				GameObject newObject = new GameObject(object, myX, myY, myType); 
				System.out.println(1);
				newObject.setIdentifier(object.getIdentifier());
				newObject.setPhysicsBody(object.getPhysicsBody());
				myRenderer.createAndAssignRenderedNode(newObject);
				myCurrentLevel.addGameObject(newObject);
			}
		}
	}
	


}
