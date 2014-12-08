package engine.actions.delete;

import engine.actions.TypeAction;
import engine.gameObject.GameObject;


public class DeleteTypeAction extends TypeAction{

	private String myType;
	
	public DeleteTypeAction(String type){
		super(type);
		
	}
	

	
	@Override
	public void execute() {
		for (GameObject object: myCurrentLevel.getGameObjectsCollection()){
			if (object.getIdentifier().getType().equals(myType)){
				myCurrentLevel.getGameObjectsCollection().remove(object);
			}
		}
		
	}

	
	

	
	
}