package engine.actions;

import java.util.List;

import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public class ChangeComponentAction implements Action, Initializable{
	
	private GameObjectsCollection myGameObjects;
	private double myValue;
	private String myComponentIDs; 
	private Identifier[] myObjectIDs; 
	
	public ChangeComponentAction(Identifier[] ids, double value, String componentIDs){
		myObjectIDs = ids; 
		myValue = value; 
		myComponentIDs = componentIDs; 
		
	}
	

	@Override
	public void initialize(GameManager manager) {
		for (Identifier id: myObjectIDs){
			myGameObjects.add(manager.objectForIdentifier(id));
		}
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		for (GameObject object: myGameObjects){
			//use method to get component from component id
			//use value to update object's component
		}
		
	}

}
