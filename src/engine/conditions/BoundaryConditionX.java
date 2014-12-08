package engine.conditions;

import java.util.ArrayList;
import java.util.List;
import engine.actions.Action;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public class BoundaryConditionX extends GameObjectCondition {
    
    private double myBoundary;
    private boolean myRightTrigger;
    
    public BoundaryConditionX (List<Action> myActions,
                              List<Identifier> myIDs,
                              Double boundary, Boolean rightTrigger) {
        super(myActions, myIDs);
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
