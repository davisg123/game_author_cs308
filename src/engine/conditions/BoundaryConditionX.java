package engine.conditions;

import java.util.List;
import engine.actions.Action;
import engine.gameObject.GameObject;

public class BoundaryConditionX extends GameObjectCondition {
    
    private double myBoundary;
    private boolean myUpTrigger;

    public BoundaryConditionX (List<Action> myActions,
                              List<GameObject> myGameObjects,
                              String identifier, double boundary, boolean upTrigger) {
        super(myActions, myGameObjects, identifier);
        myBoundary = boundary;
        myUpTrigger = upTrigger;
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
            if (myUpTrigger && obj.getTranslateX() > myBoundary || !myUpTrigger && obj.getTranslateX() < myBoundary){
                executeActions();
            }
        }
    }

}
