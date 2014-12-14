package engine.actions;

import java.util.Iterator;

import javafx.scene.Group;
import engine.GameManager;
import engine.gameObject.GameObject;
import engine.render.GameObjectRenderer;


public class DeleteTypeAction extends TypeAction{

	private transient GameObjectRenderer myRenderer; 
	
	public DeleteTypeAction(String type){
		super(type);
		
	}
	
	@Override
	public void initialize(GameManager manager){
		super.initialize(manager);
		myRenderer = manager.getRenderer();
	}
	
	
	@Override
	public void execute() {
		for (Iterator<GameObject> it = myCurrentLevel.getGameObjectsCollection().iterator(); it.hasNext();){
			GameObject object = it.next();
			if (object.getIdentifier().getType().equals(myType)){
			   
				myRenderer.removeRenderedNode(object.getIdentifier());
				it.remove();

			}
		}
		
	}

	
	

	
	
}