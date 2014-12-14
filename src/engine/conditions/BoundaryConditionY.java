package engine.conditions;

import java.util.ArrayList;
import java.util.List;
import authoring.model.collections.GameObjectsCollection;
import engine.actions.Action;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public class BoundaryConditionY extends GameObjectCondition {
    
    private Double myBoundary;
    private Boolean myUpTrigger;
    private int myCounter = 0;

    public BoundaryConditionY (List<Action> myActions,
                              List<Identifier> myIDs,
                              Double boundary, Boolean upTrigger) {
        super(myActions, myIDs);
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
    public void respondToFrameElapsed () {
        for (GameObject obj : getGameObjects()){
            if (myUpTrigger && obj.getTranslateY() > myBoundary || !myUpTrigger && obj.getTranslateY() < myBoundary){
                executeActions();
            }
        }
    }

}
