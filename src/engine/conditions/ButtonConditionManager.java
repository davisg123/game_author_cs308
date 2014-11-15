package engine.conditions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import engine.actions.Action;

/**
 * 
 * @author Davis
 * 
 * actions caused by a button press
 *
 */

public class ButtonConditionManager extends Condition {
    private Map<KeyCode, List<Action>> myKeyMap;
    private Map<KeyCode, Integer> myActiveKeyBuffer;
    
    
    public ButtonConditionManager () {
        super();
        myKeyMap = new HashMap<KeyCode, List<Action>>();
    }
    
    public void beginListeningToScene (Scene scene) {
        scene.setOnKeyPressed(event -> keyPressed(event));
        scene.setOnKeyReleased(event -> keyReleased(event));
    }
    
    private void keyReleased(KeyEvent event){
        myActiveKeyBuffer.remove(event.getCode());
    }
    
    private void keyPressed(KeyEvent event){
        myActiveKeyBuffer.put(event.getCode(), 1);
    }

    /**
     * bind a key event to an action object
     * 
     * @param key
     * trigger key as a KeyCode
     * @param action
     * action to be executed
     */
    public void addBinding (KeyCode key, Action action) {
        boolean bindingsExist = myKeyMap.containsKey(key);
        List<Action> actions = bindingsExist ? myKeyMap.get(key) : new ArrayList<Action>();
        myKeyMap.put(key, actions);
    }
    
    /**
     * remove a binding for an existing key
     * 
     * @param key
     * trigger key as a KeyCode
     */
    public void removeBinding (KeyCode key) {
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
