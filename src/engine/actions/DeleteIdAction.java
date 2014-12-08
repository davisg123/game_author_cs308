package engine.actions;

import java.util.List;

import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

/**
 * @author Shreyas
 */

public class DeleteIdAction implements Action, Initializable{

	private List<Identifier> myIDs; 
	private GameObjectsCollection myGameObjects; 
	private DeleteAction myDeleteAction; 
	
	public DeleteIdAction(List<Identifier> ids){
		myIDs = ids; 
	}
	
	
	@Override
	public void initialize(GameManager manager) {
		myGameObjects = manager.getAllGameObjects();
		
	}

	@Override
	public void execute() {
		for (GameObject object: myGameObjects){
			for (Identifier id: myIDs){
				if (id.getHash().equals(object.getIdentifier().getHash())){
					myGameObjects.remove(object);
					continue; 
				}
			}
		}
		
	}

	
	
}
