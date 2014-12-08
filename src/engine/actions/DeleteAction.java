package engine.actions;

import java.util.List;

import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import authoring.model.collections.GameObjectsCollection;

public class DeleteAction implements Action{

	private GameObjectsCollection myGameObjects; 
	private List<Identifier> myIDs; 
	
	public DeleteAction(GameObjectsCollection objects, List<Identifier> ids){
		myGameObjects = objects; 
		myIDs = ids; 
	}
	
	
	
	
	@Override
	public void execute() {
		for (GameObject object: myGameObjects){
			if (myIDs.contains(object.getIdentifier())){
				myGameObjects.remove(object);
			}
		}
		
	}

}
