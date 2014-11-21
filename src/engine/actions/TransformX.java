package engine.actions;

import engine.gameObject.GameObject;

/**
 * 
 * @author Will
 *
 */

public class TransformX extends TransformAction {

    public TransformX (GameObject sprite, double value) {
        super(sprite, value);
    }

    @Override
    public void applyTransform () {
        mySprite.setTranslateX(mySprite.getTranslateX() + myValue);
    }
    
}
