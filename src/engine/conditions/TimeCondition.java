package engine.conditions;

import java.util.List;

import engine.actions.Action;

public class TimeCondition extends Condition {
    
    private int myFrameCount = 0;
    private Double myTargetFrameCount;
    private Boolean repeats;
    private Boolean expired;

    public TimeCondition (List<Action> myActions, Double frameElapseCount, Boolean repeats) {
        super(myActions);
        expired = Boolean.FALSE;
        myTargetFrameCount = (Double) frameElapseCount;
        this.repeats = (Boolean) repeats;
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