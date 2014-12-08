package engine.actions;

import engine.gameObject.GameObject;

public class TranslateYType extends TranslateTypeAction{

	public TranslateYType(String type, Double value) {
		super(type, value);
	}

	@Override
	public void execute() {
		for (GameObject object: myGameObjects){
			if (object.getIdentifier().getType().equals(myType)){
	    		object.setTranslateY(object.getTranslateY() + myValue);
			}
		}
		
	}

	
	
	
	
}
