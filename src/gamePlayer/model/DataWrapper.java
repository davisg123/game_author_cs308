package gamePlayer.model;

import java.util.List;

import engine.conditions.Condition;
import engine.sprite.Sprite;

public class DataWrapper {

	 private List<Sprite> mySprites;
	 private List<Condition> myConditions;
	 
	 public DataWrapper(List<Sprite> sprites, List<Condition> conditions){
		 mySprites=sprites;
		 myConditions=conditions;
	 }
	 
	 public List<Sprite> getSprites(){
		 return mySprites;
	 }
	 
	 public List<Condition> getConditions(){
		 return myConditions;
	 }	
}
