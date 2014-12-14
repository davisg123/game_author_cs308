package engine.actions;

import java.util.Random;

import engine.gameObject.GameObject;
import authoring.model.collections.GameObjectsCollection;

public class MakeNewObjectFromList extends MakeNewRandomObjectAction{

	private transient GameObjectsCollection myTemplateObjects;
	
	public MakeNewObjectFromList(String type, Double lowerXBound, Double upperXBound, 
			Double lowerYBound, Double upperYBound, GameObjectsCollection objects) {
		super(type, lowerXBound, upperXBound, lowerYBound, upperYBound);
		myTemplateObjects = objects; 
		
	}
	
	@Override
	public void execute() {
		int rand = r.nextInt((int) myTemplateObjects.getSize());
		GameObject template = myTemplateObjects.get(rand); 
		super.makeRandomObject(template);
		
	}
	
}
