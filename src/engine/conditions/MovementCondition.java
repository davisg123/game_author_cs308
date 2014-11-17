package engine.conditions;

import java.util.List;
import engine.actions.Action;
import engine.sprite.Sprite;

public abstract class MovementCondition extends SpriteCondition {

    public MovementCondition (List<Action> myActions, List<Sprite> mySprites) {
        super(myActions, mySprites);
        assignListeners();
    }

    @Override
    protected void executeActions(){
        for (Action a : getActions()){
            a.execute();
        }
    }
    
    private void assignListeners(){
        for(Sprite s : getSprites()){
            s.getXPositionProperty().addListener(changeEvent -> xLayoutChange());
            s.getYPositionProperty().addListener(changeEvent -> yLayoutChange());
        }
    }
    
    protected abstract void xLayoutChange();
    
    protected abstract void yLayoutChange();
}
