package engine.actions.render;

import java.util.List;

import engine.GameManager;
import engine.actions.IDAction;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.render.GameObjectRenderer;

public class ChangeImageIDAction extends IDAction{

	private String myPathName;
	private transient GameObjectRenderer myRenderer; 
	
	public ChangeImageIDAction(List<Identifier> ids, String pathName){
		super(ids);
		myPathName = pathName; 
		
	}
	
	@Override
	public void initialize(GameManager manager){
		super.initialize(manager);
		myRenderer = manager.getRenderer();
	}
	
	@Override
	public void execute() {
		for (GameObject object: myGameObjects){
			myRenderer.removeRenderedNode(object.getIdentifier());
			object.setCurrentImagePath(myPathName);
			myRenderer.createAndAssignRenderedNode(object);
		}
	}

	
	
}
