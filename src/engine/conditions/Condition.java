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
public abstract class Condition {
    private List<Action> myEvents = new ArrayList<Action>();
    private List<Sprite> mySprites = new ArrayList<Sprite>();
    
    public List<Action> getEvents(){
        return myEvents;
    }
    
    public List<Sprite> getSprites(){
        return mySprites;
    }
}
