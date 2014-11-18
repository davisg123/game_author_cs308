package engine.collisionDetection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
    public void checkCollisions (Iterator<Node> enabledNodes) {
        myCollisionMap.clear();
        for(Iterator<Node> outerIter = enabledNodes; outerIter.hasNext();) {
            Node outerNode = outerIter.next();
            for(Iterator<Node> innerIter = enabledNodes; innerIter.hasNext();) {
                Node innerNode = innerIter.next();
                //Update the equals method, implement comparable
                if(!outerNode.getId().equals(innerNode.getId())) {
                    //Do intersect sequence
                    //make sure the opposite collision hasn't already happened (a with b == b with a)
                    String uniqueCollisionIdentifier = innerNode.getId()+outerNode.getId();
                    if(outerNode.intersects(innerNode.getBoundsInLocal()) && !myCollisionMap.containsKey(uniqueCollisionIdentifier)){
                        myCollisionMap.put(innerNode.getId()+outerNode.getId(), 1);
                        //call physics manager with collided nodes
                        
                    }
                }
            }
        }
    }

}
