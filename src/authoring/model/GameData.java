package authoring.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import engine.actions.Action;
import engine.conditions.Condition;
import engine.level.*;
import engine.sprite.Sprite;

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
	private List<Sprite> mySprites;
	private List<Condition> myConditions;
	
	public GameData (){
		myLevels = new ArrayList<Level>();
		mySprites = new ArrayList<Sprite>();
		myConditions = new ArrayList<Condition>();
	}
	
	public void addLevel(Level l){
		myLevels.add(l);
	}
	
	public void removeLevel(Level l){
		myLevels.remove(l);
	}
	
	public void addSprite(Sprite s){
		mySprites.add(s);
	}
	
	public void removeSprite(Sprite s){
		mySprites.remove(s);
	}
	
	public void addCondition(Condition c){
		myConditions.add(c);
	}
	
	public void removeCondition(Condition c){
		myConditions.remove(c);
	}
	
//	private LevelsCollection myLevels;
//	private SoundsCollection mySounds;
//	private GraphicsCollection myImages;
//	private SpritesCollection mySprites;
//	private EventCollection myEvents; //events prompt actions and hold onto their corresponding action
//	private VariableCollection myVariables;
	
	
}
