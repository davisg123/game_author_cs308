package engine.actions.movement;

import java.util.List;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

/**
 * 
 * @author Will
 *
 */

public class TranslateYID extends TranslateIDAction {

    public TranslateYID (List<Identifier> iDs, Double value) {
        super(iDs, value);
    }

    @Override
    public void applyTransform () {
    	for (GameObject object: myGameObjects){
    		object.setTranslateY(object.getTranslateY() + myValue); 
    	}

    }

}
