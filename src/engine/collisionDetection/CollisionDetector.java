package engine.collisionDetection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import engine.sprite.Sprite;
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
    public void checkCollisions (Iterator<Sprite> enabledSprites) {
        myCollisionMap.clear();
        for(Iterator<Sprite> outerIter = enabledSprites; outerIter.hasNext();) {
            Sprite outerSprite = outerIter.next();
            for(Iterator<Sprite> innerIter = enabledSprites; innerIter.hasNext();) {
                Sprite innerSprite = innerIter.next();
                //Update the equals method, implement comparable
                if(!outerSprite.getID().equals(innerSprite.getID())) {
                    //Do intersect sequence
                    //make sure the opposite collision hasn't already happened (a with b == b with a)
                    String uniqueCollisionIdentifier = innerSprite.getID()+outerSprite.getID();
                    if(outerSprite.getRenderedNode().intersects(innerSprite.getRenderedNode().getCollisionBody().getBoundsInLocal()) 
                            && !myCollisionMap.containsKey(uniqueCollisionIdentifier)){
                        myCollisionMap.put(innerSprite.getID()+outerSprite.getID(), 1);
                        //call physics manager with collided nodes
                        
                    }
                }
            }
        }
    }

}
