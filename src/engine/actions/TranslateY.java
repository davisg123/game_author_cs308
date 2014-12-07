package engine.actions;

import java.util.List;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

/**
 * 
 * @author Will
 *
 */

public class TranslateY extends TranslateAction {

    public TranslateY (List<Identifier> iDs, double value) {
        super(iDs, value);
    }

    @Override
    public void applyTransform () {
    	for (GameObject object: myGameObjects){
    		object.setTranslateY(object.getTranslateY() + myValue); 
    	}

    }

}
