package engine.actions.render;

import java.util.List;
import engine.actions.Action;
import engine.gameObject.GameObject;
import engine.level.Level;
import engine.render.GameObjectRenderer;

/**
 * Does rendering for all Sprites.
 * @author Will
 *
 */

public abstract class RenderAction implements Action, Initializable {

    protected List<GameObject> myGameObjects;
    protected GameObjectRenderer myRenderer;
    protected Level myLevel;
    
    /**
     * 
     * @param objects
     */
    //potentially just give it the ID of the objects??
    //or just give it an iterator?
    public RenderAction (List<GameObject> objects, GameObjectRenderer renderer, Level level) {
        myGameObjects = objects;
        myRenderer = renderer;
        myLevel = level;
    }

    @Override
    public void execute () {
        applyRender();
    }
    
    protected abstract void applyRender ();
    
    

}
