package engine.actions;

import java.util.Random;

import engine.gameObject.GameObject;
import authoring.model.collections.GameObjectsCollection;

public class MakeNewObjectFromList extends MakeNewRandomObjectAction{

	private GameObjectsCollection myTemplateObjects;
	
	public MakeNewObjectFromList(String type, double lowerXBound, double upperXBound, 
			double lowerYBound, double upperYBound, GameObjectsCollection objects) {
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
