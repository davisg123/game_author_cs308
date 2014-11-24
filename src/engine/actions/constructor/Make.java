package engine.actions.constructor;

import engine.gameObject.GameObject;
import engine.level.Level;

/**
 * Makes a new GameObject within a Level
 * @author Will
 *
 */

public class Make extends ConstructorAction {
    
    public Make (GameObject object, Level level) {
        super(object, level);
    }
    
    @Override
    protected void construct () {
        //level.add(object.clone());
        
    }

}
