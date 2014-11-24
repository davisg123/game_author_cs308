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
 * condition manager for conditions caused by a button press
 *
 */

public class ButtonConditionManager {
    private Map<KeyCode, Integer> myActiveKeyBuffer;
    
    private static ButtonConditionManager sharedInstance;

    // Singleton
    public static ButtonConditionManager getInstance() {
        if (sharedInstance == null) {
            sharedInstance = new ButtonConditionManager();
        }
        return sharedInstance;
    }
    
    private ButtonConditionManager () {
        myActiveKeyBuffer = new HashMap<KeyCode, Integer>();
    }
    
    protected boolean keyIsActive(KeyCode key) {
        //get active keys from our buffer
        return myActiveKeyBuffer.containsKey(key);
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
    
    private void keyReleased(KeyEvent event){
        myActiveKeyBuffer.remove(event.getCode());
    }
    
    private void keyPressed(KeyEvent event){
        myActiveKeyBuffer.put(event.getCode(), 1);
    }

}
