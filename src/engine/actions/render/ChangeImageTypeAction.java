package engine.actions.render;

import engine.GameManager;
import engine.actions.TypeAction;
import engine.gameObject.GameObject;
import engine.render.GameObjectRenderer;

public class ChangeImageTypeAction extends TypeAction{

	private String myPathName; 
	private transient GameObjectRenderer myRenderer; 
	
	public ChangeImageTypeAction(String type, String pathname){
		super(type);
		myPathName = pathname; 
	}

	@Override
	public void initialize(GameManager manager){
		super.initialize(manager);
		myRenderer = manager.getRenderer();
	}
	
	
	@Override
	public void execute() {
		
		for (GameObject object: myCurrentLevel.getGameObjectsCollection()){
			if (object.getIdentifier().getType().equals(myType)){
				myRenderer.removeRenderedNode(object.getIdentifier());
				object.setCurrentImagePath(myPathName);
				myRenderer.createAndAssignRenderedNode(object);
				
			}
			
		}
		
	}
	
	
	
}
