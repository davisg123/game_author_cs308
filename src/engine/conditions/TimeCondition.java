package engine.conditions;

import java.util.List;
import engine.actions.Action;
import engine.gameObject.GameObject;

public class TimeCondition extends GameObjectCondition {
    
    private int myFrameCount = 0;
    private double mySecondsToExecute;
    private boolean repeats;
    private boolean expired;

    public TimeCondition (List<Action> myActions, List<GameObject> myGameObjects, String identifier, double secondsToExecute, boolean repeats) {
        super(myActions, myGameObjects, identifier);
        mySecondsToExecute = secondsToExecute;
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
            if(myFrameCount > mySecondsToExecute*60){
                executeActions();
                myFrameCount = repeats ? 0 : myFrameCount;
                expired = !repeats;
            }
        }
    }
    
}