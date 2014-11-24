package engine.actions.translate;

import engine.GameManager;
import engine.gameObject.GameObject;

/**
 * 
 * @author Will
 *
 */

public class TranslateX extends TranslateAction {

    public TranslateX (GameObject sprite, double value) {
        super(sprite, value);
    }

    @Override
    public void applyTransform () {
        mySprite.setTranslateX(mySprite.getTranslateX() + myValue);
    }

    @Override
    public void initialize (GameManager manager) {
        
    }
    
}
