package gamePlayer.model;

import java.util.List;

import authoring.model.collections.ConditionsCollection;
import authoring.model.collections.GameObjectCollection;
import authoring.model.collections.LevelsCollection;
import engine.conditions.Condition;
import engine.gameObject.GameObject;
import engine.level.Level;

/**
 * 
 * @author Abhishek B
 * @author Eli Lichtenberg
 * 
 */

public class DataWrapper {

	private LevelsCollection myLevels;
	private GameObjectCollection myGameObjects;
	private ConditionsCollection myConditions;
	 
	 public DataWrapper(LevelsCollection levels, GameObjectCollection objects, ConditionsCollection conditions){
		 myLevels = levels;
		 myGameObjects=objects;
		 myConditions=conditions;
	 }
	 
	 public LevelsCollection getLevels(){
		 return myLevels;
	 }
	 
	 public GameObjectCollection getGameObjects(){
		 return myGameObjects;
	 }
	 
	 public ConditionsCollection getConditions(){
		 return myConditions;
	 }	
}
