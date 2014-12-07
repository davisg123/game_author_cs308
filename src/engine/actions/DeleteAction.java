package engine.actions;

import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifiable;
import engine.gameObject.Identifier;

public class DeleteAction implements Action, Initializable{

	private Identifier myID; 
	private String myType;
	private Identifier[] objectIDs;
	private GameObjectsCollection myGameObjects; 
	
	public DeleteAction(String type, Identifier... ids){
		myType=type;
		objectIDs=ids; 
	}
	
	@Override
	public void initialize(GameManager manager) {
		myGameObjects = manager.getLevelManager().getCurrentLevel().getGameObjectsCollection();
	}

	@Override
	public void execute() {
		
	}

	
	

	
	
}
