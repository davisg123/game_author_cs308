package engine.conditions;

import java.util.List;
import authoring.model.collections.GameObjectsCollection;
import engine.actions.Action;
import engine.gameObject.GameObject;

public class TimeCondition extends GameObjectCondition {
    
    private int myFrameCount = 0;
    private double myTargetFrameCount;
    private boolean repeats;
    private boolean expired;

    public TimeCondition (List<Action> myActions, GameObjectsCollection myGameObjects, String identifier, double frameElapseCount, boolean repeats) {
        super(myActions, myGameObjects, identifier);
        myTargetFrameCount = frameElapseCount;
        this.repeats = repeats;
    }

    @Override
    protected void executeActions () {
        for(Action a : getActions()){
            a.execute();
        }
    }
    
    @Override
    public void frameElapsed () {
        if (!expired){
            myFrameCount++;
            if(myFrameCount >= myTargetFrameCount){
                executeActions();
                myFrameCount = repeats ? 0 : myFrameCount;
                expired = !repeats;
            }
        }
    }
    
}