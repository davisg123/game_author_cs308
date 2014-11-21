package engine.actions;

import engine.gameObject.GameObject;

/**
 * 
 * @author Will
 *
 */

public abstract class TransformAction implements Action {
    protected GameObject mySprite;
    protected double myValue;
    
    public TransformAction (GameObject sprite, double value) {
        mySprite = sprite;
        myValue = value;
    }
    @Override
    public void execute () {
        applyTransform();
    }
    
    public abstract void applyTransform ();
    
}
