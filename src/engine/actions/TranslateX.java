package engine.actions;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

/**
 * 
 * @author Will
 *
 */

public class TranslateX extends TranslateAction {

    public TranslateX (Identifier iD, double value) {
        super(iD, value);
    }

    @Override
    public void applyTransform () {
        mySprite.setTranslateX(mySprite.getTranslateX() + myValue);
    }
    
}
