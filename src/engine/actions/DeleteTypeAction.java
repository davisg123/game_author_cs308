package engine.actions;

import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifiable;
import engine.gameObject.Identifier;

public class DeleteTypeAction implements Action, Initializable{

	private String myType;
	private GameObjectsCollection myGameObjects; 
	
	public DeleteTypeAction(String type, Identifier... ids){
		myType=type;
	}
	
	@Override
	public void initialize(GameManager manager) {
		
		myGameObjects = manager.getLevelManager().getCurrentLevel().getGameObjectsCollection();
	}

	@Override
	public void execute() {
 
		for (GameObject object: myGameObjects){
			if (object.getIdentifier().getType().equals(myType)){
				myGameObjects.remove(object);
			}
		}
		
	}

	
	

	
	
}
