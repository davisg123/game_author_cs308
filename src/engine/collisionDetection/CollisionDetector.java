package engine.collisionDetection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import authoring.model.collections.GameObjectsCollection;
import engine.gameObject.GameObject;
import javafx.scene.Node;

/**
 * Handle logic for JavaFX node intersections/collision...
 * TODO check if we can just implement a time based Condition and action for this
 * 
 * @author Will Chang
 *
 */

public class CollisionDetector {

    private Map<String,Integer> myCollisionMap = new HashMap<String,Integer>();
    //Should they just be enabled nodes? or should they be all the nodes?
    //Discuss definition of enabled
    
    /**
     * Checks whether any of the GameObjects have collided, and calls the GameObjects
     * to handle the collisions.
     * A list is needed here vs. an iterator because of the double loop
     * @param enabledNodes
     */
    public void checkCollisions (GameObjectsCollection enabledGameObjects) {
        myCollisionMap.clear();
        for(GameObject innerGameObject : enabledGameObjects) {
            for(GameObject outerGameObject : enabledGameObjects) {
                //Update the equals method, implement comparable
                if(!outerGameObject.getID().equals(innerGameObject.getID())) {
                    //Do intersect sequence
                    //make sure the opposite collision hasn't already happened (a with b == b with a)
                    String uniqueCollisionIdentifier = innerGameObject.getID()+outerGameObject.getID();
                    if(outerGameObject.getRenderedNode().getBoundsInParent().intersects(innerGameObject.getRenderedNode().getBoundsInParent()) 
                            && !myCollisionMap.containsKey(uniqueCollisionIdentifier)){
                    	outerGameObject.getPhysicsBody().handleCollision(outerGameObject, innerGameObject);
                        System.out.println("collision");
                        myCollisionMap.put(innerGameObject.getID()+outerGameObject.getID(), 1);
                        //call physics manager with collided nodes
                        
                    }
                }
            }
        }
    }

}
