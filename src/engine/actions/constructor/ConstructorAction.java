package engine.actions.constructor;

import java.util.ArrayList;
import java.util.List;
import engine.actions.Action;
import engine.actions.render.PaintCanvas;
import engine.gameObject.GameObject;
import engine.level.Level;

/**
 * SuperClass for Actions which construct other GameObjects
 * @author Will
 *
 */

public abstract class ConstructorAction implements Action {
    protected GameObject myGameObject;
    protected Level myLevel;
    protected PaintCanvas myPaintCanvasAction;

    public ConstructorAction () {

    }

    public ConstructorAction (GameObject object, Level level) {
        myGameObject = object;
        myLevel = level;
        List<GameObject> buffer = new ArrayList<>();
        buffer.add(object);
        myPaintCanvasAction = new PaintCanvas(buffer,null, level);
    }    
    
    //TODO Add Initializable and initialize the PaintCanvas.

    @Override
    public void execute () {
        construct();
    }

    protected abstract void construct ();

}
