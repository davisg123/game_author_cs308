package gamePlayer.model;

import java.util.List;

import engine.conditions.Condition;
import engine.gameObject.GameObject;

public class DataWrapper {

	 private List<GameObject> myGameObjects;
	 private List<Condition> myConditions;
	 
	 public DataWrapper(List<GameObject> sprites, List<Condition> conditions){
		 myGameObjects=sprites;
		 myConditions=conditions;
	 }
	 
	 public List<GameObject> getGameObjects(){
		 return myGameObjects;
	 }
	 
	 public List<Condition> getConditions(){
		 return myConditions;
	 }	
}
