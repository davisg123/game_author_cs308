package engine.actions;

import engine.gameObject.GameObject;

/**
 * Action that performs GameObject Transforms/Movements
 * @author Will
 *
 */

public abstract class TranslateAction implements Action {
    protected GameObject mySprite;
    protected double myValue;
    
    public TranslateAction (GameObject sprite, double value) {
        mySprite = sprite;
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
