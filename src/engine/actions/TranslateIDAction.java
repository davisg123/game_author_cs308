package engine.actions;

import java.util.List;

import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

/**
 * Action that performs GameObject Transforms/Movements
 * @author Will
 *
 */

public abstract class TranslateIDAction implements Action, Initializable {
    protected GameObjectsCollection myGameObjects;
    protected List<Identifier> myGameObjectIDs;
    protected Double myValue;
    
    public TranslateIDAction (List<Identifier> iDs, Double value) {
        myGameObjectIDs = iDs;
        myValue = value;
        myGameObjects = new GameObjectsCollection();
    }
    
    @Override
    public void execute () {
        applyTransform();
    }
    
    @Override
    public void initialize (GameManager manager) {
    	for (Identifier id: myGameObjectIDs){
    		myGameObjects.add(manager.objectForIdentifier(id));
    	}

    }
    
    /**
     * Applies the specific transform in X and Y
     */
    public abstract void applyTransform ();
    
}
