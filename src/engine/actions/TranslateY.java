package engine.actions;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

/**
 * 
 * @author Will
 *
 */

public class TranslateY extends TranslateAction {

    public TranslateY (Identifier iD, double value) {
        super(iD, value);
    }

    @Override
    public void applyTransform () {
        mySprite.setTranslateY(mySprite.getTranslateY() + myValue);
    }

    @Override
    public void initialize (GameManager manager) {
        
    }

}
