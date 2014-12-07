package engine.conditions;

import java.util.ArrayList;
import java.util.List;
import authoring.model.collections.GameObjectCollection;
import engine.actions.Action;
import engine.gameObject.GameObject;

/**
 * abstract class for conditions based on the position of game objects
 * 
 * @author Davis
 *
 */
public abstract class GameObjectCondition extends Condition {
    private GameObjectCollection myGameObjects;
    
    public GameObjectCondition (List<Action> myActions, GameObjectCollection myGameObjects) {
        super(myActions);
        this.myGameObjects = myGameObjects;
    }
    
    public void setGameObjects(GameObjectCollection gameObjects){
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
    
    public GameObjectCollection getGameObjects(){
        return myGameObjects;
    }
}
