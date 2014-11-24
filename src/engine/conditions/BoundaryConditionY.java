package engine.conditions;

import java.util.List;
import engine.actions.Action;
import engine.gameObject.GameObject;

public class BoundaryConditionY extends GameObjectCondition {
    
    private double myBoundary;
    private boolean myRightTrigger;

    public BoundaryConditionY (List<Action> myActions,
                              List<GameObject> myGameObjects,
                              String identifier, double boundary, boolean rightTrigger) {
        super(myActions, myGameObjects, identifier);
        myBoundary = boundary;
        myRightTrigger = rightTrigger;
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
            if (myRightTrigger && obj.getTranslateX() > myBoundary || !myRightTrigger && obj.getTranslateX() < myBoundary){
                executeActions();
            }
        }
    }

}
