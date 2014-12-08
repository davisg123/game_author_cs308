package engine.actions;

import java.util.List;

import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

/**
 * 
 * @author Will
 *
 */

public class TranslateXID extends TranslateIDAction {

    public TranslateXID (List<Identifier> iDs, double value) {
        super(iDs, value);
    }

    @Override
    public void applyTransform () {
    	for (GameObject object: myGameObjects){
    		object.setTranslateX(object.getTranslateX() + myValue);
    	}

    }
    
}
