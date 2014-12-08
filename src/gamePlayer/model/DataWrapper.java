package gamePlayer.model;

import authoring.model.collections.ConditionsCollection;
import authoring.model.collections.GameObjectsCollection;
import authoring.model.collections.LevelsCollection;

/**
 * 
 * @author Abhishek B
 * @author Eli Lichtenberg
 * 
 */

public class DataWrapper {

	private LevelsCollection myLevels;
	private GameObjectsCollection myGameObjects;
	private ConditionsCollection myConditions;
	 
	 public DataWrapper(LevelsCollection levels, GameObjectsCollection objects, ConditionsCollection conditions){
		 myLevels = levels;
		 myGameObjects=objects;
		 myConditions=conditions;
	 }
	 
	 public LevelsCollection getLevels(){
		 return myLevels;
	 }
	 
	 public GameObjectsCollection getGameObjects(){
		 return myGameObjects;
	 }
	 
	 public ConditionsCollection getConditions(){
		 return myConditions;
	 }	
}
