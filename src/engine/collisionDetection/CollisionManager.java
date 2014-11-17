package engine.collisionDetection;

import java.util.Iterator;
import javafx.scene.Node;

/**
 * Handle logic for JavaFX node intersections/collision...
 * TODO check if we can just implement a time based Condition and action for this
 * 
 * @author Will Chang
 *
 */

public class CollisionManager {

    
    //Should they just be enabled nodes? or should they be all the nodes?
    //Discuss definition of enabled
    public void checkCollisions (Iterator<Node> enabledNodes) {
        for(Iterator<Node> outerIter = enabledNodes; outerIter.hasNext();) {
            Node outerNode = outerIter.next();
            for(Iterator<Node> innerIter = enabledNodes; innerIter.hasNext();) {
                Node innerNode = innerIter.next();
                //Update the equals method, implement comparable, 
                //change to ID comparison
                if(!outerNode.equals(innerNode)) {
                    //Do intersect sequence
                    //TODO what do I do with this information?
                    outerNode.intersects(innerNode.getBoundsInLocal());
                }
            }
        }
    }

}
