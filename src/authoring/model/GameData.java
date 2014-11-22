package authoring.model;

import java.io.Serializable;
import authoring.model.collections.ConditionsCollection;
import authoring.model.collections.GameObjectsCollection;
import authoring.model.collections.ImagesCollection;
import authoring.model.collections.LevelsCollection;
import authoring.model.collections.SoundsCollection;
import engine.conditions.Condition;
import engine.level.*;
import engine.gameObject.GameObject;

/**
 * Passive data object that holds onto all of the
 * data that represents an authored game.
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Arjun Jain
 * @author Kevin Li
 *
 */
public class GameData implements Serializable{

	/**
	 * Maybe put in properties file?
	 */
	private static final long serialVersionUID = 6633782568176674709L;
	
	private LevelsCollection myLevels;
	private ConditionsCollection myConditions;
	private GameObjectsCollection myGameObjects;
	private ImagesCollection myImages;
	private SoundsCollection mySounds;
	
	public GameData(){
		myLevels = new LevelsCollection();
		myGameObjects = new GameObjectsCollection();
		myConditions = new ConditionsCollection();
		myImages = new ImagesCollection();
		mySounds = new SoundsCollection();
	}
	
	/**
	 * Level Methods
	 */
	
	public LevelsCollection getLevels(){
		return myLevels;
	}
	
	public void addLevel(Level l){
		myLevels.add(l);
	}
	
	public void removeLevel(Level l){
		myLevels.remove(l);
	}
	
	/**
	 * GameObject Methods
	 */
	
	public GameObjectsCollection getGameObjects(){
		return myGameObjects;
	}
	
	public void addGameObject(GameObject s){
		myGameObjects.add(s);
	}
	
	public void removeGameObject(GameObject s){
		myGameObjects.remove(s);
	}
	
	/**
	 * Condition Methods
	 */
	
	public ConditionsCollection getConditions(){
		return myConditions;
	}
	
	public void addCondition(Condition c){
		myConditions.add(c);
	}
	
	public void removeCondition(Condition c){
		myConditions.remove(c);
	}
	
	/**
	 * Graphic Methods
	 */
	
	public ImagesCollection getImages(){
		return myImages;
	}
	
	/**
	 * Sound Methods
	 */
	
	public SoundsCollection getSounds(){
		return mySounds;
	}
	
	
	
}
