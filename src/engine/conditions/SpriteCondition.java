package engine.conditions;

import java.util.ArrayList;
import java.util.List;
import engine.actions.Action;
import engine.sprite.Sprite;

/**
 * 
 * @author Davis
 *
 */
public abstract class SpriteCondition extends Condition {
    private List<Action> myActions = new ArrayList<Action>();
    private List<Sprite> mySprites = new ArrayList<Sprite>();
    
    public SpriteCondition (List<Action> myActions, List<Sprite> mySprites) {
        super();
        this.myActions = myActions;
        this.mySprites = mySprites;
    }

    public List<Action> getActions(){
        return myActions;
    }
    
    public List<Sprite> getSprites(){
        return mySprites;
    }
}
