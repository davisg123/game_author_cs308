package engine.level;

import java.util.Iterator;
import java.util.List;

import authoring.model.collections.ConditionsCollection;
import authoring.model.collections.GameObjectsCollection;
import authoring.model.collections.LevelsCollection;
import engine.collisionDetection.CollisionDetector;
import engine.conditions.Condition;
import engine.render.GameObjectRenderer;
import engine.gameObject.GameObject;

/**
 * Manages the Levels, and progression of the Game
 * 
 * @author Will Chang
 * @author Abhishek Balakrishnan
 */

public class LevelManager implements Iterable<Level> {
	private LevelsCollection myLevels;
	private GameObjectsCollection myGameObjects;
	private ConditionsCollection myConditions;
	private Level myCurrentLevel;
	private int myCurrentIndex;
	private GameObjectRenderer myRenderer;
	private CollisionDetector myDetector;

	/**
	 * Constructor for a level
	 * 
	 * @param gameObjects
	 * @param levels
	 * @param conditions
	 * @param renderer
	 * @param detector
	 */
	public LevelManager(LevelsCollection levels, GameObjectsCollection gameObjects,
			ConditionsCollection conditions, GameObjectRenderer renderer,
			CollisionDetector detector) {
		myLevels = levels;
		myGameObjects = gameObjects;
		myConditions = conditions;
		myCurrentIndex = 0;
		myCurrentLevel = myLevels.get(myCurrentIndex);
		myRenderer = renderer;
		myDetector = detector;
	}

	/**
	 * Iterates through the list of Levels in the managers
	 */
	public Iterator<Level> iterator() {
		return myLevels.iterator();
	}

	/**
	 * Primitive implementation of level loop...
	 */
	public void nextLevel() {
		if (myCurrentIndex < myLevels.size() - 1) {
			myCurrentIndex += 1;
			myCurrentLevel = myLevels.get(myCurrentIndex);
		} else {
			myCurrentIndex = 0;
		}
	}

	/**
	 * Sets current Level and initializes
	 * 
	 * @param levelIndex
	 */
	public void goToLevel(int levelIndex) {
		myCurrentLevel = myLevels.get(levelIndex);
		initializeCurrentLevel();
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
		setLevelEnabledConditions();
		myRenderer.renderGameObjects(myCurrentLevel);
	}

	/**
     * Set conditions in this level to 
     */
	private void setLevelEnabledConditions() {
		for (Iterator<String> conditionIDIterator = myCurrentLevel.getConditionIDsIterator(); conditionIDIterator
				.hasNext();) {
			String conditionID = conditionIDIterator.next();
			
//			for (Iterator<Condition> conditionIterator = myConditions.iterator() )
			/*
			 * find the condition in myConditions specified by this conditionID
			 * and set it enabled
			 */
		}
	}
	
	/**
	 * 
	 */

}
