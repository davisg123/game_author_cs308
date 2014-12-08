package engine.actions.delete;

import java.util.List;

import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.actions.IDAction;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public class DeleteIdAction extends IDAction{

	private GameObjectsCollection myGameObjects; 
	
	
	public DeleteIdAction(List<Identifier> ids){
		super(ids);
	}
	
	
	@Override
	public void initialize(GameManager manager) {
		myGameObjects = manager.getAllGameObjects();
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
