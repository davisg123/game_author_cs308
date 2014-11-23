package engine.actions.constructor;

import java.util.List;
import engine.actions.render.PaintCanvas;
import engine.gameObject.GameObject;
import engine.level.Level;

public class MakeRelative extends ConstructorAction {

    private List<GameObject> myRelatedGameObjects;
    
    public MakeRelative (GameObject object, List<GameObject> objects, Level level) {
        super(object, level);
        //Objects need to be copied...
        myRelatedGameObjects = objects;
        myPaintCanvasAction = new PaintCanvas(objects, null, level);
    }
    
    //Add Initializable interface.
    //
    //initialize PaintCanvasAction

    @Override
    protected void construct () {
        for(GameObject o : myRelatedGameObjects) {
            //Objects need to be copied...
            o.setOrientation(myGameObject.getOrientation());
            o.setX(myGameObject.getX());
            o.setY(myGameObject.getY());
        }
        myPaintCanvasAction.execute();
    }

}
