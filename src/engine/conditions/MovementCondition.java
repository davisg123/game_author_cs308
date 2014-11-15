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
public abstract class MovementCondition {
    private List<Action> myActions = new ArrayList<Action>();
    private List<Sprite> mySprites = new ArrayList<Sprite>();
    
    public MovementCondition (List<Action> myActions, List<Sprite> mySprites) {
        super();
        this.myActions = myActions;
        this.mySprites = mySprites;
        assignListeners();
    }

    public List<Action> getActions(){
        return myActions;
    }
    
    public List<Sprite> getSprites(){
        return mySprites;
    }
    
    protected void executeEvents(){
        for (Action a : myActions){
            a.execute();
        }
    }
    
    private void assignListeners(){
        for(Sprite s : mySprites){
            s.getNode().layoutXProperty().addListener(changeEvent -> xLayoutChange());
            s.getNode().layoutXProperty().addListener(changeEvent -> yLayoutChange());
        }
    }
    
    protected abstract void xLayoutChange();
    
    protected abstract void yLayoutChange();
}
