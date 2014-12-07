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
    protected Identifier[] myGameObjectIDs;
    
    public GameObjectCondition (List<Action> myActions, Identifier[] myIDs) {
        super(myActions);
        this.myGameObjectIDs = myIDs;
    }
    
    @Override
    public void initialize(GameManager gameManager){
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
