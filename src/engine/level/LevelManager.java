package engine.level;

import java.util.Iterator;
import authoring.model.collections.ConditionsCollection;
import authoring.model.collections.GameObjectsCollection;
import authoring.model.collections.LevelsCollection;
import engine.conditions.Condition;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.render.GameObjectRenderer;

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
	private ConditionsCollection myConditions;
	private Level myCurrentLevel;
	private int myCurrentIndex;
	private GameObjectRenderer myRenderer;

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
			GameObjectRenderer renderer) {
		myLevels = levels;
		myGameObjects = gameObjects;
		myConditions = conditions;
		myCurrentIndex = 0;
		myCurrentLevel = myLevels.get(myCurrentIndex);
		myRenderer = renderer;
                myCurrentLevel.initialize(this);
                myRenderer.renderGameObjects(myCurrentLevel);
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
		if(myLevels.iterator().hasNext()) {
			myCurrentIndex++;
			myCurrentLevel = myLevels.iterator().next();
		}
		else {
			myCurrentIndex = 0;
		}
		
//		if (myCurrentIndex < myLevels.size() - 1) {
//			myCurrentIndex += 1;
//			myCurrentLevel = myLevels.get(myCurrentIndex);
//		} else {
//			myCurrentIndex = 0;
//		}
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
		disableAllConditions();
		setLevelEnabledConditions();
		myCurrentLevel.initialize(this);
		myRenderer.renderGameObjects(myCurrentLevel);
	}

	/**
	 * Iterate through all level's condition IDs and turn on the corresponding
	 * condition from master list
	 */
	private void setLevelEnabledConditions() {
		for (Iterator<String> conditionIDIterator = myCurrentLevel
				.getConditionIDsIterator(); conditionIDIterator.hasNext();) {
			String conditionID = conditionIDIterator.next();
			enableCondition(conditionID);
		}
	}

	public void changeLevel(String id){
//		for (Level l: LevelsCollection){
//			if (l.getID().equals(id)){
//				myCurrentLevel=l;
//			}
//		}
	}
	
	public GameObject objectForIdentifier(Identifier Id){
	    for (GameObject g : myGameObjects){
	        if (g.getIdentifier().getHash().equals(Id.getHash())){
	            return g;
	        }
	    }
	    return null;
	}

	/**
	 * Find condition in master list and enable it
	 * @param conditionID
	 */
	private void enableCondition(String conditionID) {
		for (Iterator<Condition> conditionIterator = myConditions.iterator(); conditionIterator
				.hasNext();) {
			Condition condition = conditionIterator.next();
			if (condition.getIdentifier().getUniqueId() == conditionID)
				condition.setEnabled(true);
		}
	}

	/**
	 * Disable all conditions before enabling the correct ones
	 */
	private void disableAllConditions() {
		for (Iterator<Condition> conditionIterator = myConditions.iterator(); conditionIterator
				.hasNext();) {
			conditionIterator.next().setEnabled(false);
		}
	}

}
