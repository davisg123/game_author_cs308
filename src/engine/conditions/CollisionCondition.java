package engine.conditions;

import java.util.List;
import javafx.scene.Node;
import engine.actions.Action;
import engine.sprite.Sprite;

/**
 * 
 * @author Davis
 * 
 * actions caused by collisions of two nodes
 *
 */

public class CollisionCondition extends MovementCondition {

    public CollisionCondition (List<Action> myActions, List<Sprite> mySprites) {
        super(myActions, mySprites);
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
