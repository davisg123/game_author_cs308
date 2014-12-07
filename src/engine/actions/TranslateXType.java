package engine.actions;

import engine.gameObject.GameObject;

/**
 * @author Shreyas
 */

public class TranslateXType extends TranslateTypeAction {
	
	public TranslateXType(String type, double value){
		super(type, value);
	}

	@Override
	public void execute() {
		for (GameObject object: myGameObjects){
			if (object.getIdentifier().getType().equals(myType)){
	    		object.setTranslateX(object.getTranslateX() + myValue);
			}
		}
	}
	
	

}
