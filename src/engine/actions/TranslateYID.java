package engine.actions;

import java.util.List;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

/**
 * 
 * @author Will
 * @author Shreyas
 */

public class TranslateYID extends TranslateIDAction {

    public TranslateYID (List<Identifier> iDs, double value) {
        super(iDs, value);
    }

    @Override
    public void applyTransform () {
    	for (GameObject object: myGameObjects){
    		object.setTranslateY(object.getTranslateY() + myValue); 
    	}

    }

}
