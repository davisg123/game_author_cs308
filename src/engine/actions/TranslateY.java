package engine.actions;

import engine.gameObject.GameObject;

/**
 * 
 * @author Will
 *
 */

public class TranslateY extends TranslateAction {

    public TranslateY (GameObject sprite, double value) {
        super(sprite, value);
    }

    @Override
    public void applyTransform () {
        mySprite.setTranslateY(mySprite.getTranslateY() + myValue);
    }

}
