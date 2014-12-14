package engine.actions;

import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.gameObject.GameObject;
import engine.level.Level;

public class RotateImageTypeAction implements Action, Initializable {
    
    protected transient GameObjectsCollection myGameObjects; 
    protected transient Level myCurrentLevel;
    protected String myType; 
    protected Double myAngle;
    
    public RotateImageTypeAction(String type, Double angle){
            myType = type; 
            myAngle = angle; 
    }

    @Override
    public void initialize (GameManager manager) {
        myGameObjects = manager.getLevelManager().getCurrentLevel().getGameObjectsCollection();
    }

    @Override
    public void execute () {
        for (GameObject object: myGameObjects){
            if (object.getIdentifier().getType().equals(myType)){
                object.getRenderedNode().getImageView().setRotate(myAngle);
            }
        }
    }


}
