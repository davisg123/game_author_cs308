package engine.actions;

import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.render.GameObjectRenderer;

public class LabelIntIncrementAction implements Action, Initializable {
	private Identifier myLabelID;
	private transient GameObject obj;
	private transient GameManager myManager;
	
	public LabelIntIncrementAction (Identifier labelID) {
		myLabelID = labelID;
	}
	
	@Override
	public void initialize(GameManager manager) {
		myManager = manager;
		GameObjectsCollection collection = manager.getAllGameObjects();
		for(GameObject object : collection) {
			if(object.getIdentifier().equals(myLabelID)) {
				obj = object;
			}
		}
	}

	@Override
	public void execute() {
		if(obj != null) {
			GameObjectRenderer renderer = myManager.getRenderer();
			Integer i = Integer.valueOf(obj.getLabel());
			i+=1;
			renderer.removeRenderedNode(myLabelID);
			obj.setLabel(i.toString());
			renderer.createAndAssignRenderedNode(obj);
		}
	}

}
