package engine.actions;

import engine.sprite.Sprite;

/**
 * 
 * @author Will
 *
 */

public class TransformX extends TransformAction {

    public TransformX (Sprite sprite, double value) {
        super(sprite, value);
    }

    @Override
    public void applyTransform () {
        mySprite.setTranslateX(mySprite.getTranslateX() + myValue);
    }
    
}
