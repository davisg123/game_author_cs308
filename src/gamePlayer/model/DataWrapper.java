package gamePlayer.model;

import java.util.List;

import authoring.model.collections.ConditionsCollection;
import authoring.model.collections.GameObjectsCollection;
import authoring.model.collections.LevelsCollection;
import engine.conditions.Condition;
import engine.gameObject.GameObject;
import engine.level.Level;

/**
 * 
 * @author Abhishek B
 * @author Eli Lichtenberg
 * @author Shreyas
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
