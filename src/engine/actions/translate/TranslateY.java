package engine.actions.translate;

import engine.GameManager;
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

    @Override
    public void initialize (GameManager manager) {
        
    }

}
