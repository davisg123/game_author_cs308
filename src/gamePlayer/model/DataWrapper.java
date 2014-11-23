package gamePlayer.model;

import java.util.List;

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

	private List<Level> myLevels;
	private List<GameObject> myGameObjects;
	private List<Condition> myConditions;
	 
	 public DataWrapper(List<Level> levels, List<GameObject> sprites, List<Condition> conditions){
		 myLevels = levels;
		 myGameObjects=sprites;
		 myConditions=conditions;
	 }
	 
	 public List<Level> getLevels(){
		 return myLevels;
	 }
	 
	 public List<GameObject> getGameObjects(){
		 return myGameObjects;
	 }
	 
	 public List<Condition> getConditions(){
		 return myConditions;
	 }	
}
