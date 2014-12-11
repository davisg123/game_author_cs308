package engine.actions;

import java.util.List;

import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public abstract class IDAction implements Action, Initializable{

	protected List<Identifier> myIDs;
	protected GameObjectsCollection myGameObjects; 
	
	public IDAction(List<Identifier> ids){
		myIDs = ids; 
	}
	
	@Override
	public void initialize(GameManager manager) {
		for (GameObject object: manager.getAllGameObjects()){
			if (myIDs.contains(object.getIdentifier())){
				myGameObjects.add(object);
			}
		}
	}


	

}
