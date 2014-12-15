// This entire file is part of my masterpiece.
// Davis Gossage

package engine.conditions;

import java.util.List;
import javafx.scene.input.KeyCode;
import engine.actions.Action;

/**
 * 
 * @author Davis
 * 
 * a condition that listens for a button release
 *
 */

public class ButtonReleaseCondition extends ButtonCondition {

    public ButtonReleaseCondition (List<Action> onReleaseActions, List<KeyCode> keyList) {
        super(onReleaseActions, keyList);
    }

    @Override
    protected void executeActions () {
        for (KeyCode myKey : getKeyMap().keySet()){
            if (ButtonConditionManager.getInstance().keyIsActive(myKey)){
                getKeyMap().put(myKey, Boolean.TRUE);
            }
            else if (getKeyMap().get(myKey) && !ButtonConditionManager.getInstance().keyIsActive(myKey)){
                //the key was pressed, now it's not
                for (Action a : getActions()){
                    a.execute();
                }
                getKeyMap().put(myKey, Boolean.FALSE);
            }
        }
    }

}
