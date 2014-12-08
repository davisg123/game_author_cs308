package engine.actions;

import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.gameObject.GameObject;
import engine.level.Level;

public abstract class TranslateTypeAction extends TypeAction{

	protected GameObjectsCollection myGameObjects; 
	protected Level myCurrentLevel;
	protected double myValue;
	
	public TranslateTypeAction(String type, double value){
		super(type); 
		myValue = value; 
	}
	
	

}
