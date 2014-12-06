package engine.conditions;

import java.util.List;
import authoring.model.collections.GameObjectsCollection;
import engine.actions.Action;
import engine.gameObject.GameObject;

public class BoundaryConditionY extends GameObjectCondition {
    
    private double myBoundary;
    private boolean myUpTrigger;

    public BoundaryConditionY (List<Action> myActions,
                              GameObjectsCollection myGameObjects,
                              double boundary, boolean rightTrigger) {
        super(myActions, myGameObjects);
        myBoundary = boundary;
        myUpTrigger = rightTrigger;
    }

    @Override
    protected void executeActions () {
        for(Action a : getActions()){
            a.execute();
        }
    }
    
    @Override
    public void frameElapsed () {
        for (GameObject obj : getGameObjects()){
            if (myUpTrigger && obj.getTranslateY() > myBoundary || !myUpTrigger && obj.getTranslateY() < myBoundary){
                executeActions();
            }
        }
    }

}
