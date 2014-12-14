package engine.actions;

import java.util.Random;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.gameObject.components.PhysicsBody;

public class MakeNewObjectFromObjectAction extends MakeNewObjectAction {

	private Identifier objectID; 
	private transient GameObject myObject; 
	
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
				newObject.setIdentifier(new Identifier(object.getIdentifier()));
				newObject.setPhysicsBody(new PhysicsBody(object.getPhysicsBody()));
				myRenderer.createAndAssignRenderedNode(newObject);
				newObject.setOrientation(myObject.getOrientation());
				myCurrentLevel.addGameObject(newObject);	
			}
			
		}
		
		
	}

}
