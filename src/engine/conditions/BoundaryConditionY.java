package engine.conditions;

import java.util.List;

import authoring.model.collections.GameObjectsCollection;
import engine.actions.Action;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public class BoundaryConditionY extends GameObjectCondition {
    
    private double myBoundary;
    private boolean myUpTrigger;

    public BoundaryConditionY (List<Action> myActions,
                              GameObjectsCollection myGameObjects,
                              Identifier[] myIDs,
                              double boundary, boolean rightTrigger) {
        super(myActions, myIDs);
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
