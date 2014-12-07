package engine.conditions;

import java.util.List;

import engine.actions.Action;

public class TimeCondition extends Condition {
    
    private int myFrameCount = 0;
    private double myTargetFrameCount;
    private boolean repeats;
    private boolean expired;

    public TimeCondition (List<Action> myActions, double frameElapseCount, boolean repeats) {
        super(myActions);
        
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