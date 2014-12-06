package engine.actions;

import java.util.List;

import authoring.model.collections.GameObjectsCollection;
import engine.gameObject.GameObject;

/**
 * Action that performs GameObject Transforms/Movements
 * @author Will
 *
 */

public abstract class TranslateAction implements Action, Initializable {
    protected GameObjectsCollection mySprites;
    protected double myValue;
    
    public TranslateAction (GameObjectsCollection sprites, double value) {
        mySprites = sprites;
        myValue = value;
    }
    @Override
    public void execute () {
        applyTransform();
    }
    
    /**
     * Applies the specific transform in X and Y
     */
    public abstract void applyTransform ();
    
}
