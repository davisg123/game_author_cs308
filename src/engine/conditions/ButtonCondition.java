// This entire file is part of my masterpiece.
// Davis Gossage

package engine.conditions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.scene.input.KeyCode;
import engine.actions.Action;

/**
 * 
 * @author Davis
 * 
 * base button condition class which holds a map of keys that are active
 * condition holds a map of keys, and polls the button manager every frame to see if keys are active
 *
 */

public abstract class ButtonCondition extends Condition {
    
    private Map<KeyCode, Boolean> myKeyMap;

    public ButtonCondition (List<Action> actions, List<KeyCode> keyList) {
        super(actions);
        myKeyMap = new HashMap<KeyCode, Boolean>();
        for (KeyCode myKey : keyList) {
            myKeyMap.put(myKey, Boolean.FALSE);
        }
    }
    
    /**
     * get the list of keys that are currently being monitored for this condition
     * 
     * @return
     * list of active keys
     */
    public List<KeyCode> getKeyList () {
        List<KeyCode> generatedKeyCodeList = new ArrayList<KeyCode>();
        for (KeyCode kc : myKeyMap.keySet()) {
            generatedKeyCodeList.add(kc);
        }
        return generatedKeyCodeList;
    }
    
    /**
     * add a key to the list of keys that are currently being monitored for this condition
     * @param kc
     * keycode to add
     */
    public void addKey (KeyCode kc) {
        myKeyMap.put(kc, Boolean.FALSE);
    }
    
    /**
     * remove a key from the list of keys that are currently being monitored for this condition
     * @param kc
     * keycode to remove
     */
    public void removeKey (KeyCode kc) {
        myKeyMap.remove(kc);
    }
    
    @Override
    public void respondToFrameElapsed () {
        executeActions();
    }
    
    protected Map<KeyCode, Boolean> getKeyMap () {
        return myKeyMap;
    }

}
