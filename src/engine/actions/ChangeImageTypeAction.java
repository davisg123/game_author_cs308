package engine.actions;

import engine.gameObject.GameObject;

public class ChangeImageTypeAction extends TypeAction{

	String myPathName; 
	
	public ChangeImageTypeAction(String type, String pathname){
		super(type);
		myPathName = pathname; 
	}

	@Override
	public void execute() {
		
		for (GameObject object: myCurrentLevel.getGameObjectsCollection()){
			
			object.setCurrentImagePath(myPathName);
			
		}
		
	}
	
	
	
}
