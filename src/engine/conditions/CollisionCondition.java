package engine.conditions;

import java.util.List;
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

public class CollisionCondition extends MovementCondition {

    public CollisionCondition (List<Action> myActions, List<GameObject> myGameObjects) {
        super(myActions, myGameObjects);
    }

    @Override
    protected void xLayoutChange () {
        checkCollision();
    }

    @Override
    protected void yLayoutChange () {
        checkCollision();
    }
    
    private void checkCollision() {
        //use the detector class
    }

   
}
