package engine.conditions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import authoring.model.collections.GameObjectsCollection;
import javafx.scene.Node;
import engine.actions.Action;
import engine.gameObject.GameObject;

/**
 * 
 * @author Davis
 * 
 * conditions caused by collisions of two nodes
 *
 */

public class CollisionCondition extends TimeCondition {
    
    private GameObjectsCollection mySecondCollisionSet;
    private Map<String,Integer> myCollisionMap;

    public CollisionCondition (List<Action> myActions, GameObjectsCollection firstCollisionSet, GameObjectsCollection secondCollisionSet) {
        //initialize as a time condition that executes every frame
        super(myActions,firstCollisionSet,1,true);
        mySecondCollisionSet = secondCollisionSet;
        myCollisionMap = new HashMap<String,Integer>();
    }
    
    @Override
    protected void executeActions () {
        //see what collisions are active
        checkCollisions();
    }
    
    private void checkCollisions() {
        myCollisionMap.clear();
        for(GameObject innerGameObject : getGameObjects()) {
            for(GameObject outerGameObject : mySecondCollisionSet) {
                //Update the equals method, implement comparable
                if(!outerGameObject.getID().equals(innerGameObject.getID())) {
                    //Do intersect sequence
                    //make sure the opposite collision hasn't already happened (a with b == b with a)
                    String uniqueCollisionIdentifier = innerGameObject.getID()+outerGameObject.getID();
                    String reverseCollisionIdentifier = outerGameObject.getID()+innerGameObject.getID();
                    boolean isDuplicate = myCollisionMap.containsKey(uniqueCollisionIdentifier) || myCollisionMap.containsKey(reverseCollisionIdentifier);
                    if(outerGameObject.getRenderedNode().getBoundsInParent().intersects(innerGameObject.getRenderedNode().getBoundsInParent()) 
                            && !isDuplicate){
                        outerGameObject.getPhysicsBody().handleCollision(outerGameObject, innerGameObject);
                        myCollisionMap.put(uniqueCollisionIdentifier, 1);
                    }
                }
            }
        }
    }

   
}
