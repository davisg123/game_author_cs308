package engine.conditions;

import java.util.ArrayList;
import java.util.List;
import engine.actions.Action;
import engine.gameObject.GameObject;

/**
 * 
 * @author Davis
 *
 */
public abstract class GameObjectCondition extends Condition {
    private List<Action> myActions = new ArrayList<Action>();
    private List<GameObject> myGameObjects = new ArrayList<GameObject>();
    
    public GameObjectCondition (List<Action> myActions, List<GameObject> myGameObjects) {
        super();
        this.myActions = myActions;
        this.myGameObjects = myGameObjects;
    }

    public List<Action> getActions(){
        return myActions;
    }
    
    public List<GameObject> getGameObjects(){
        return myGameObjects;
    }
}
