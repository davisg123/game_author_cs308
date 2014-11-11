package engine.conditions;

import java.util.List;
import engine.actions.Action;

/**
 * 
 * @author Davis
 * 
 * actions caused by a button press
 *
 */

public class ButtonCondition extends Condition {
    private char triggerKey;
    
    public ButtonCondition (char triggerKey) {
        super();
        this.triggerKey = triggerKey;
    }

    @Override
    public boolean isEnabled () {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Action> getEvents () {
        // TODO Auto-generated method stub
        return null;
    }

}
