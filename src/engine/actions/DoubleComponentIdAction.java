package engine.actions;

import java.util.List;
import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public class DoubleComponentIdAction implements Action, Initializable {
    private List<Identifier> myIDs; 
    private GameObjectsCollection myGameObjects; 
    
    
    public DoubleComponentIdAction(List<Identifier> ids){
            myIDs = ids; 
    }
    
    
    @Override
    public void initialize(GameManager manager) {
            myGameObjects = manager.getAllGameObjects();
    }

    @Override
    public void execute() {
            for (GameObject object: myGameObjects){
                    if (myIDs.contains(object.getIdentifier())){
                            myGameObjects.remove(object);
                    }
            }
            
    }
}
