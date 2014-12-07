package engine.level;

import java.util.Iterator;

import data.Observable;
import authoring.model.collections.ConditionIDsCollection;
import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.actions.Initializable;
import engine.gameObject.GameObject;
import engine.gameObject.Identifiable;
import engine.gameObject.Identifier;

/**
 * A Level of the game. Contains all GameObjects and Actions and coordinates
 * their interactions for linear progression through the game.
 * 
 * @author Will Chang
 * @author Abhishek Balakrishnan
 */

public class Level extends Observable implements Identifiable, Initializable {

        private Identifier myId;
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
	 * SET INITIAL VALUES FOR THE MAIN CHARACTER
	 */
	public void updateMainCharacter() {

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

	public void addGameObject(GameObject gameObject) {
		myDefaultGameObjects.add(gameObject);
		setChanged();
		notifyObservers(this);
	}
	
	public boolean removeGameObject(GameObject g){
		boolean ret = myDefaultGameObjects.remove(g);
		setChanged();
		notifyObservers(this);
		return ret;
	}

	public GameObjectsCollection getGameObjectsCollection() {
		return myDefaultGameObjects;
	}

        @Override
        public void setIdentifier (Identifier myId) {
            this.myId = myId;
        }
        
        @Override
        public Identifier getIdentifier () {
            return myId;
        }

        @Override
        public void initialize (GameManager manager) {
            //TODO: enable/disable conditions and render game objects
        }

}
