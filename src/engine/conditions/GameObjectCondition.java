package engine.conditions;

import java.util.ArrayList;
import java.util.List;
import engine.actions.Action;
import engine.gameObject.GameObject;

/**
 * abstract class for conditions based on the position of game objects
 * 
 * @author Davis
 *
 */
public abstract class GameObjectCondition extends Condition {
    private List<GameObject> myGameObjects = new ArrayList<GameObject>();
    
    public GameObjectCondition (List<Action> myActions, List<GameObject> myGameObjects, String identifier) {
        super(myActions,identifier);
        this.myGameObjects = myGameObjects;
    }
    
    public List<GameObject> getGameObjects(){
        return myGameObjects;
    }
}
