package engine.actions;

import engine.gameObject.GameObject;
import engine.level.Level;

/**
 * Makes a new GameObject within a Level
 * @author Will
 *
 */

public class Make extends InitializationAction {

    public Make (GameObject object, Level level) {
        super(object,level);
    }
    
    @Override
    protected void initialize () {
        //level.add(object.copy());
    }

}
