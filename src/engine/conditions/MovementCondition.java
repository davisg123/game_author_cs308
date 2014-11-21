package engine.conditions;

import java.util.List;
import engine.actions.Action;
import engine.gameObject.GameObject;

public abstract class MovementCondition extends GameObjectCondition {

    public MovementCondition (List<Action> myActions, List<GameObject> myGameObjects) {
        super(myActions, myGameObjects);
        assignListeners();
    }

    @Override
    protected void executeActions(){
        for (Action a : getActions()){
            a.execute();
        }
    }
    
    private void assignListeners(){
        for(GameObject s : getGameObjects()){
            s.getXPositionProperty().addListener(changeEvent -> xLayoutChange());
            s.getYPositionProperty().addListener(changeEvent -> yLayoutChange());
        }
    }
    
    protected abstract void xLayoutChange();
    
    protected abstract void yLayoutChange();
}
