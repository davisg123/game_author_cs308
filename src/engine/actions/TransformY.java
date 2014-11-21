package engine.actions;

import engine.gameObject.GameObject;

/**
 * 
 * @author Will
 *
 */

public class TransformY extends TransformAction {

    public TransformY (GameObject sprite, double value) {
        super(sprite, value);
    }

    @Override
    public void applyTransform () {
        mySprite.setTranslateY(mySprite.getTranslateY() + myValue);
    }

}
