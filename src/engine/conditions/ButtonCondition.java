package engine.conditions;

import java.util.ArrayList;
import engine.actions.Action;
import javafx.scene.input.KeyCode;

public class ButtonCondition extends Condition {
    
    private KeyCode myKey;

    public ButtonCondition (ArrayList<Action> actions, KeyCode key) {
        super(actions);
        myKey = key;
    }
    
    

    @Override
    protected void executeActions () {
        if (ButtonConditionManager.getInstance().keyIsActive(myKey)){
            for (Action a : getActions()){
                a.execute();
            }
        }
    }
    
    @Override
    public void frameElapsed () {
        executeActions();
    }
}
