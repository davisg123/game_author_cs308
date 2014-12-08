package engine.actions;

import engine.gameObject.GameObject;

public class MakeNewObjectFromLocationAction extends MakeNewObjectAction{

	private double myX; 
	private double myY; 
	
	public MakeNewObjectFromLocationAction(String type, double x, double y) {
		super(type);
		myX = x; 
		myX = y; 
		
	}

	@Override
	public void execute() {
		for (GameObject object: myMasterList){
			//TODO: will be template list
			if (object.getIdentifier().getType().equals(myType)){
				GameObject newObject = new GameObject(object, myX, myY, myType); 
				myRenderer.createAndAssignRenderedNode(newObject);
				myCurrentLevel.addGameObject(newObject);
			}
		}
	}

}
