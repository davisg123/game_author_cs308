package engine.level;

import java.util.Iterator;
import authoring.model.collections.ConditionsCollection;
import authoring.model.collections.GameObjectsCollection;
import authoring.model.collections.LevelsCollection;
import engine.conditions.Condition;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.render.GameObjectRenderer;
import engine.sound.SoundUtility;

/**
 * Manages the Levels, and progression of the Game
 * 
 * @author Will Chang
 * @author Abhishek Balakrishnan
 * @author Eli Lichtenberg
 */

public class LevelManager implements Iterable<Level> {
	private LevelsCollection myLevels;
	private GameObjectsCollection myGameObjects;
	private GameObjectsCollection myTemplateObjects;
	private ConditionsCollection myConditions;
	private Level myCurrentLevel;
	// private int myCurrentIndex;
	private GameObjectRenderer myRenderer;
	private SoundUtility mySoundPlayer;
	
	/**
	 * Constructor for a level
	 * 
	 * @param gameObjects
	 * @param levels
	 * @param conditions
	 * @param renderer
	 * @param detector
	 */
	public LevelManager(LevelsCollection levels,
			GameObjectsCollection gameObjects, ConditionsCollection conditions,
			GameObjectRenderer renderer, SoundUtility soundPlayer) {
		myLevels = levels;
		myGameObjects = gameObjects;
		myConditions = conditions;
		myRenderer = renderer;
		mySoundPlayer = soundPlayer;
		myTemplateObjects = new GameObjectsCollection(); 
		makeTemplates(); 
		findAndSetStartLevel(levels);
	}

	/**
	 * TODO undo duplicated code...
	 * 
	 * @param levels
	 */
	private void findAndSetStartLevel(LevelsCollection levels) {
		// Authoring must have set a startLevel, and only 1 start level
		for (Level level : levels) {
			if (level.isStartLevel()) {
				myCurrentLevel = level;
				initializeCurrentLevel();
				break;
			}
		}
	}

	private void setCurrentLevel(Level level) {
		myCurrentLevel = level;
		initializeCurrentLevel();
	}

	/**
	 * Iterates through the list of Levels in the managers
	 */
	public Iterator<Level> iterator() {
		return myLevels.iterator();
	}

	/**
	 * Sets current Level and initializes
	 * 
	 * @param levelIndex
	 */
	public void changeToLevel(Identifier iD) {
		for (Level level : myLevels) {
			if (level.getIdentifier().equals(iD)) {
				setCurrentLevel(level);
				break;
			}
		}
	}

	/**
	 * Update call, updates the current level Happens every frame
	 */
	public void update() {
		myCurrentLevel.update();
		updateFrameBasedConditions();
	}

	/**
	 * update the conditions that rely on frame calculations
	 */
	private void updateFrameBasedConditions() {
		for (Condition s : myConditions) {
			s.frameElapsed();
		}
	}

	/**
	 * Initializes the Current Level
	 */
	public void initializeCurrentLevel() {
		disableAllConditions();
		setLevelEnabledConditions();
		
		for(Level level : myLevels) {
		    mySoundPlayer.stopBackGroundMusic(level.getBackgroundMusic());
		}
		mySoundPlayer.playBackGroundMusic(myCurrentLevel.getBackgroundMusic());
		myCurrentLevel.initialize(this);
		myRenderer.renderGameObjects(myCurrentLevel);
		
	}

	/**
	 * Iterate through all level's condition IDs and turn on the corresponding
	 * condition from master list
	 */
	private void setLevelEnabledConditions() {
		for (Identifier conditionID : myCurrentLevel.getConditionIdentifiers()) {
			enableCondition(conditionID);
		}
	}

	public GameObject objectForIdentifier(Identifier Id) {
		for (GameObject g : myGameObjects) {
			if (g.getIdentifier().equals(Id)) {
				return g;
			}
		}
		return null;
	}

	/**
	 * Find condition in master list and enable it
	 * 
	 * @param conditionID
	 */
	private void enableCondition(Identifier conditionID) {
		for (Condition condition : myConditions) {
		    if (condition.getIdentifier().equals(conditionID)){
		                              condition.setEnabled(true);
		                         }
		}
	}

	private void makeTemplates(){
		for (GameObject object: myGameObjects){
			if (object.getIdentifier().getUniqueId().equals("Template")){
				myTemplateObjects.add(object);
			}
		}
	}
	
	/**
	 * Disable all conditions before enabling the correct ones
	 */
	private void disableAllConditions() {
		for (Condition c : myConditions) {
			c.setEnabled(false);
		}
	}

	public Level getCurrentLevel() {
		return myCurrentLevel;
	}

	public GameObjectsCollection getGameObjects() {
		return myGameObjects;
	}
	
	public GameObjectsCollection getTemplates(){
		return myTemplateObjects; 
	}

}
