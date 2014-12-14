package engine.actions;

import java.util.Random;

import engine.gameObject.GameObject;

public class TranslateXRandomType extends TranslateTypeAction {
	
	private Double myLowerBound;
	private Double myUpperBound;
	
	public TranslateXRandomType(String type, Double lowerBound, Double upperBound){
		super(type, (lowerBound + upperBound)/2);
		myLowerBound = lowerBound;
		myUpperBound = upperBound;
	}

	@Override
	public void execute() {
		Random r = new Random();
		myValue = r.nextInt((int) (myUpperBound-myLowerBound)) + myLowerBound;
		for (GameObject object: myGameObjects){
			if (object.getIdentifier().getType().equals(myType)){
	    		object.setTranslateX(object.getTranslateX() + myValue);
			}
		}
	}

}
