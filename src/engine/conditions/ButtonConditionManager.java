// This entire file is part of my masterpiece.
// Davis Gossage

package engine.conditions;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * 
 * @author Davis
 * 
 * button condition manager singleton for conditions caused by a button press
 * manager holds a map of all active keys, allowing for multiple button presses to be recognized
 *
 */

public class ButtonConditionManager {
    
    private Map<KeyCode, Integer> myActiveKeyBuffer;
    private static ButtonConditionManager sharedInstance;

    /**
     * access the shared instance of the button condition manager
     * 
     * @return shared singleton
     */
    public static ButtonConditionManager getInstance() {
        if (sharedInstance == null) {
            sharedInstance = new ButtonConditionManager();
        }
        return sharedInstance;
    }

    /**
     * tell the button condition manager to begin listening for key presses in a particular scene
     * @param scene
     * the scene to listen to
     */
    public void beginListeningToScene (Scene scene) {
        scene.setOnKeyPressed(event -> keyPressed(event));
        scene.setOnKeyReleased(event -> keyReleased(event));
    }
    
    /**
     * check active keys from our buffer
     * @param key
     * key code to check if active
     * @return
     * boolean representing if key is active
     */
    protected boolean keyIsActive(KeyCode key) {
        return myActiveKeyBuffer.containsKey(key);
    }
    
    private ButtonConditionManager () {
        myActiveKeyBuffer = new HashMap<KeyCode, Integer>();
    }
    
    private void keyReleased(KeyEvent event){
        myActiveKeyBuffer.remove(event.getCode());
    }
    
    private void keyPressed(KeyEvent event){
        myActiveKeyBuffer.put(event.getCode(), 1);
    }

}
