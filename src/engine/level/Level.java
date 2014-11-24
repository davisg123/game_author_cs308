package engine.level;

import java.util.Iterator;

import authoring.model.collections.ConditionIDsCollection;
import authoring.model.collections.GameObjectsCollection;
import engine.gameObject.GameObject;

/**
 * A Level of the game. Contains all GameObjects and Actions and coordinates
 * their interactions for linear progression through the game.
 * 
 * @author Will Chang
 * @author Abhishek Balakrishnan
 */

public class Level {

	private String myLevelID;
	private GameObjectsCollection myDefaultGameObjects;
	private GameObjectsCollection myWorkingGameObjects;
	private ConditionIDsCollection myConditionIDs;

	/**
	 * Constructor
	 * 
	 * @param Game
	 *            Objects Collection
	 */
	public Level(GameObjectsCollection gameObjects) {
		myDefaultGameObjects = gameObjects;
		myWorkingGameObjects = gameObjects;
	}

	/**
	 * Reset method for the GameObjects
	 */
	public void resetLevel() {
		myWorkingGameObjects = myDefaultGameObjects;
	}

	/**
	 * Updates all GameObjects.
	 */
	public void update() {
		for (GameObject sprite : myWorkingGameObjects) {
			sprite.update();
		}
	}

	/**
	 * @return Iterator for GameObjectCollection
	 */
	public Iterator<GameObject> getGameObjectIterator() {
		return myWorkingGameObjects.iterator();
	}

	/**
	 * @return Iterator for the ConditionIDsCollection
	 */
	public Iterator<String> getConditionIDsIterator() {
		return myConditionIDs.iterator();
	}

}
