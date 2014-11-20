package engine.conditions;

import java.util.List;
import engine.actions.Action;
import engine.sprite.Sprite;

public class TimeCondition extends SpriteCondition {
    
    private int myFrameCount = 0;
    private double mySecondsToExecute;
    private boolean repeats;
    private boolean expired;

    public TimeCondition (List<Action> myActions, List<Sprite> mySprites, double secondsToExecute, boolean repeats) {
        super(myActions, mySprites);
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