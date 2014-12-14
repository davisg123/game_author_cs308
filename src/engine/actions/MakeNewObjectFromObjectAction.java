package engine.actions;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public class MakeNewObjectFromObjectAction extends MakeNewObjectAction {

	private Identifier objectID; 
	private GameObject myObject; 
	
	public MakeNewObjectFromObjectAction(String type, Identifier id) {
		super(type);
		objectID = id; 
		
	}

	@Override
	public void initialize(GameManager gameManager){
		super.initialize(gameManager);
		myObject = gameManager.objectForIdentifier(objectID);
		
	}
	
	@Override
	public void execute() {
		for (GameObject object: myMasterList){
			//TODO: To TEMPLATELIST
			if (object.getIdentifier().getType().equals(myType)){
				GameObject newObject = new GameObject(object, myObject.getTranslateX(), myObject.getTranslateY(), myType);
				newObject.setIdentifier(object.getIdentifier());
				newObject.setPhysicsBody(object.getPhysicsBody());
				myRenderer.createAndAssignRenderedNode(newObject);
				newObject.setOrientation(myObject.getOrientation());
				myCurrentLevel.addGameObject(newObject);	
			}
			
		}
		
		
	}

}
