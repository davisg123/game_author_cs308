package engine.actions;

import authoring.model.collections.GameObjectsCollection;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.gameObject.components.PhysicsBody;

public class MakeNewObjectFromLocationAction extends MakeNewObjectAction{

	private Double myX; 
	private Double myY; 
	
	public MakeNewObjectFromLocationAction(String type, Double x, Double y) {
		super(type);
		myX = x; 
		myY = y; 
		
	}

	@Override
	public void execute() {
		for (GameObject object: myMasterList){
		    //System.out.println(object.getIdentifier().getHash());
			//TODO: will be template list
			if (object.getIdentifier().getType().equals(myType)){
				GameObject newObject = new GameObject(object, myX, myY, myType); 
				newObject.setIdentifier(new Identifier(object.getIdentifier()));
				newObject.setPhysicsBody(new PhysicsBody(object.getPhysicsBody()));
				myRenderer.createAndAssignRenderedNode(newObject);
				myCurrentLevel.addGameObject(newObject);
			}
		}
	}
	


}
