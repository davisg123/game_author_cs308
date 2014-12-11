package engine.level;

import java.util.ArrayList;
import java.util.Iterator;
import data.Observable;
import java.util.List;
import authoring.model.collections.GameObjectsCollection;
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
    private String myBackgroundImage;
    private String myBackgroundMusic;
    private GameObjectsCollection myDefaultGameObjects;
    private GameObjectsCollection myWorkingGameObjects;
    private List<Identifier> myGameObjectIdList;
    private List<Identifier> myConditionIdList;
    private boolean myStartLevelIndicator;

    /**
     * Constructor
     * 
     * @param IdList
     * list representing game objects that apply to this level
     */
    public Level(List<Identifier> IdList) {
        this(new GameObjectsCollection());
        myGameObjectIdList = IdList;

    }

    public Level (GameObjectsCollection gameObjects) {
        this(gameObjects, false);
    }
    
    //TODO need to add ID list for the Conditions
    public Level(List<Identifier> objectIdList, List<Identifier> conditionIdList, boolean isStart) {
        myGameObjectIdList = objectIdList;
        myConditionIdList = conditionIdList;
        myDefaultGameObjects = new GameObjectsCollection();
        myWorkingGameObjects = new GameObjectsCollection();
        myStartLevelIndicator = isStart;
    }

    public Level (GameObjectsCollection gameObjects, boolean isStart) {
        myGameObjectIdList = new ArrayList<Identifier>();
        myConditionIdList = new ArrayList<Identifier>();
        myDefaultGameObjects = gameObjects;
        myWorkingGameObjects = gameObjects;
        myStartLevelIndicator = isStart;
    }

    /**
     * Reset method for the GameObjects
     */
    public void resetLevel() {
        myWorkingGameObjects = new GameObjectsCollection(myDefaultGameObjects);
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

    public void addGameObject(GameObject gameObject) {
        myWorkingGameObjects.add(gameObject);
        setChanged();
        notifyObservers(this);
    }
    
    public void addInitialGameObjects(GameObject gameObject){
        myWorkingGameObjects.add(gameObject);
    }

    public boolean removeGameObject(GameObject g){
        boolean ret = myDefaultGameObjects.remove(g);
        setChanged();
        notifyObservers(this);
        return ret;
    }

    public GameObjectsCollection getGameObjectsCollection() {
        return myWorkingGameObjects;
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
    
    public List<Identifier> getConditionIdentifiers() {
    	return myConditionIdList;
    }
    
    public Iterator<Identifier> getConditionIds () {
        return (new ArrayList<Identifier>()).iterator();
    }
    
    public List<Identifier> getConditionCollection(){
    	return myConditionIdList;
    }
    
    public void setGameObjectIds (List<Identifier> iDList) {
        myGameObjectIdList = iDList;
    }
    
    public void setConditionIds (List<Identifier> iDList) {
        myConditionIdList = iDList;
    }
    
    public void setStartIndicator(boolean indicator) {
        myStartLevelIndicator = indicator;
    }
    
    public boolean isStartLevel() {
        return myStartLevelIndicator;
    }
    
    public List<Identifier> getGameObjectIDs(){
    	return myGameObjectIdList; 
    }
    
    public void setBackgroundImage(String s){
    	myBackgroundImage = s;
    }
    
    public void setBackgroundMusic(String s){
    	myBackgroundMusic = s;
    }
    
    public String getBackgroundImage(){
    	return myBackgroundImage;
    }

    public String getBackgroundMusic(){
    	return myBackgroundMusic;
    }
}
