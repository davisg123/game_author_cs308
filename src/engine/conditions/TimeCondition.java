package engine.conditions;

import java.util.List;

import engine.actions.Action;
import engine.gameObject.Identifier;

public class TimeCondition extends GameObjectCondition {
    
    private int myFrameCount = 0;
    protected double myTargetFrameCount;
    protected boolean repeats;
    private boolean expired;

    public TimeCondition (List<Action> myActions, Identifier[] myIDs, double frameElapseCount, boolean repeats) {
        super(myActions, myIDs);
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