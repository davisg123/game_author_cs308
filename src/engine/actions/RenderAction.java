package engine.actions;

import java.util.List;
import engine.gameObject.GameObject;

/**
 * Does rendering for all Sprites.
 * @author Will
 *
 */

public class RenderAction implements Action {

    private List<GameObject> myGameObjects;
    
    public RenderAction (List<GameObject> objects) {
        myGameObjects = objects;
    }

    @Override
    public void execute () {
        // TODO Auto-generated method stub

    }

}
