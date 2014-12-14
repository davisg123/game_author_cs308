package engine.actions;

import java.util.List;
import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public class ChangeComponentIDAction implements Action, Initializable{
	
	protected transient GameObjectsCollection myGameObjects;
	protected transient Identifier myComponentID; 
	protected transient List<Identifier> myObjectIDs; 
	
	public ChangeComponentIDAction(List<Identifier> ids, Identifier componentID){
		myObjectIDs = ids; 
		myComponentID = componentID; 
		
	}
	

	@Override
	public void initialize(GameManager manager) {
		for (Identifier id: myObjectIDs){
			myGameObjects.add(manager.objectForIdentifier(id));
		}
		
	}


    @Override
    public void execute () {
        // TODO Auto-generated method stub
        
    }

	

}
