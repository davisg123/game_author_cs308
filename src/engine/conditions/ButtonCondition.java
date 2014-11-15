package engine.conditions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.scene.Scene;
import engine.actions.Action;

/**
 * 
 * @author Davis
 * 
 * actions caused by a button press
 *
 */

public class ButtonCondition extends Condition {
    private Map<Character, List<Action>> myKeyMap;
    private List<Character> myActiveKeyBuffer;
    
    
    

    public ButtonCondition () {
        super();
        myKeyMap = new HashMap<Character, List<Action>>();
    }
    
    
    public void beginListeningToScene (Scene scene) {
        scene.setOnKeyPressed(arg0);
        scene.setOnKeyReleased(arg0);
    }

    /**
     * bind a key event to an action object
     * 
     * @param key
     * trigger key
     * @param action
     * action to be executed
     */
    public void addBinding (Character key, Action action) {
        boolean bindingsExist = myKeyMap.containsKey(key);
        List<Action> actions = bindingsExist ? myKeyMap.get(key) : new ArrayList<Action>();
        myKeyMap.put(key, actions);
    }
    
    /**
     * remove a binding for an existing key
     * 
     * @param key
     * trigger key
     */
    public void removeBinding (Character key) {
        myKeyMap.remove(key);
    }
    
    /**
     * clear all of the bindings
     */
    public void clearAllBindings () {
        myKeyMap.clear();
    }

    @Override
    public List<Action> getEvents () {
        return null;
    }

}
