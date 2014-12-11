package engine.conditions;

import java.util.ArrayList;
import java.util.List;

import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.actions.Action;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

/**
 * abstract class for conditions based on the position of game objects
 * 
 * @author Davis
 *
 */
public abstract class GameObjectCondition extends Condition {
 
    
    protected GameObjectsCollection myGameObjects;
    protected List<Identifier> myGameObjectIDs;
    
    public GameObjectCondition (List<Action> myActions, List<Identifier> myIDs) {
        super(myActions);
        myGameObjects = new GameObjectsCollection();
        this.myGameObjectIDs = myIDs;
    }
    
    @Override
    public void initialize(GameManager gameManager){
        initializeActions(gameManager);
    	for (Identifier id: myGameObjectIDs){
    		myGameObjects.add(gameManager.objectForIdentifier(id));
    	}
        
        
    }
    
    public void setGameObjects(GameObjectsCollection gameObjects){
        myGameObjects = gameObjects;
    }
    
    public void addGameObject(GameObject object){
        myGameObjects.add(object);
    }
    
    public boolean removeGameObject(String objectId){
        for (GameObject obj : myGameObjects){
            if (obj.getID().equals(objectId)){
                myGameObjects.remove(obj);
                return true;
            }
        }
        return false;
    }
    
    public GameObjectsCollection getGameObjects(){
        return myGameObjects;
    }
    
    
    
}
