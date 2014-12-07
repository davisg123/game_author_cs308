package engine.actions;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

/**
 * @author Shreyas
 */

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
		
		
		
	}

}
