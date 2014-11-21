package authoring.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import authoring.view.graphicsview.Graphic;
import engine.actions.Action;
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
	
	private List<Level> myLevels;
	//private List<GameObject> myGameObjects;
	private List<Condition> myConditions;
	private GameObjectCollection myGameObjects;
	
	public GameData(){
		myLevels = new ArrayList<Level>();
		myGameObjects = new GameObjectCollection();
		myConditions = new ArrayList<Condition>();
		myImages = new GraphicsCollection();
	}
	
	public void addLevel(Level l){
		myLevels.add(l);
	}
	
	public void removeLevel(Level l){
		myLevels.remove(l);
	}
	
	public void addGameObject(GameObject s){
		myGameObjects.addGameObject(s);
	}
	
//	public void removeGameObject(GameObject s){
//		myGameObjects.remove(s);
//	}
	
	public void addCondition(Condition c){
		myConditions.add(c);
	}
	
	public void removeCondition(Condition c){
		myConditions.remove(c);
	}
	
//	private LevelsCollection myLevels;
//	private SoundsCollection mySounds;
//	private GraphicsCollection myImages;
		
	private SoundsCollection mySounds;
	private GraphicsCollection myImages;
	
	
	
	public GraphicsCollection getImages(){
		return myImages;
	}
	public GameObjectCollection getGameObjects(){
		return myGameObjects;
	}
	
//	private EventCollection myEvents; //events prompt actions and hold onto their corresponding action
//	private VariableCollection myVariables;
	
	
}
