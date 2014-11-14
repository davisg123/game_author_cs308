package gamePlayer.model;

import java.util.List;

import engine.conditions.Condition;
import engine.sprite.Sprite;

public class DataWrapper {

	 private List<Sprite> mySprites;
	 private List<Condition> myConditions;
	 
	 public List<Sprite> getSprites(){
		 return mySprites;
	 }
	 
	 public List<Condition> getConditions(){
		 return myConditions;
	 }
	
}
