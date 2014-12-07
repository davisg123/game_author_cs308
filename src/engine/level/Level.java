package engine.level;

import java.util.Iterator;
import data.Observable;
import java.util.List;
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

public class Level extends Observable implements Identifiable {

    private Identifier myId;
    private GameObjectsCollection myDefaultGameObjects;
    private GameObjectsCollection myWorkingGameObjects;
    private List<Identifier> myGameObjectIdList;
    private List<Identifier> myConditionIdList;
    private ConditionIDsCollection myConditionIDs;
    private boolean myStartLevelIndicator;

    /**
     * Constructor
     * 
     * @param IdList
     * list representing game objects that apply to this level
     */
    public Level (GameObjectsCollection gameObjects) {
        this(gameObjects, false);
    }
    
    //TODO need to add ID list for the Conditions
    public Level(List<Identifier> IdList, boolean isStart) {
        this(new GameObjectsCollection(), isStart);
        myGameObjectIdList = IdList;

    }

    public Level (GameObjectsCollection gameObjects, boolean isStart) {
        myDefaultGameObjects = gameObjects;
        myWorkingGameObjects = gameObjects;
        myStartLevelIndicator = isStart;
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

    public void initialize (LevelManager manager) {
        for (Identifier i : myGameObjectIdList){
            GameObject foundObject = manager.objectForIdentifier(i);
            if (foundObject != null){
                myDefaultGameObjects.add(foundObject);
                myWorkingGameObjects.add(foundObject);
            }
        }
    }
    
    public void setStartIndicator(boolean indicator) {
        myStartLevelIndicator = indicator;
    }
    
    public boolean isStartLevel() {
        return myStartLevelIndicator;
    }

}
