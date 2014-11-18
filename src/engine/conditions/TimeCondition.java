package engine.conditions;

import java.util.List;
import engine.actions.Action;
import engine.sprite.Sprite;

public class TimeCondition extends SpriteCondition {
    
    private int myFrameCount = 0;

    public TimeCondition (List<Action> myActions, List<Sprite> mySprites) {
        super(myActions, mySprites);
    }

    @Override
    protected void executeActions () {
        
    }
    
    @Override
    public void frameElapsed () {
        myFrameCount++;
    }
    
}