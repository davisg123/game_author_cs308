package engine.actions;

import java.util.List;

import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.gameObject.GameObject;

/**
 * 
 * @author Will
 *
 */

public class TranslateY extends TranslateAction {

    public TranslateY (GameObjectsCollection sprites, double value) {
        super(sprites, value);
    }

    @Override
    public void applyTransform () {
        for (GameObject sprite: mySprites){
        	sprite.setTranslateY(sprite.getTranslateY() + myValue);
        }
    }
    
    @Override
    public void initialize (GameManager manager) {
        
    }

}
