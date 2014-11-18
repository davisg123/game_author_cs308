package engine.actions;

import engine.sprite.Sprite;

/**
 * 
 * @author Will
 *
 */

public class TransformY extends TransformAction {

    public TransformY (Sprite sprite, double value) {
        super(sprite, value);
    }

    @Override
    public void applyTransform () {
        mySprite.setTranslateY(mySprite.getTranslateY() + myValue);
    }

}
