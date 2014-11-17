package engine.actions;

import engine.sprite.Sprite;

/**
 * 
 * @author Will
 *
 */

public abstract class TransformAction implements Action {
    protected Sprite mySprite;
    protected double myValue;
    
    public TransformAction (Sprite sprite, double value) {
        mySprite = sprite;
        myValue = value;
    }
    @Override
    public void execute () {
        applyTransform();
    }
    
    public abstract void applyTransform ();
    
}
