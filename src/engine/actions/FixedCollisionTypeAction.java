package engine.actions;

import engine.gameObject.GameObject;
import authoring.model.collections.GameObjectsCollection;

public class FixedCollisionTypeAction extends PhysicsTypeAction {

    public FixedCollisionTypeAction (String type, String secondType, Double value) {
        super(type, secondType, value);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void applyPhysics (GameObjectsCollection myObjects) {
        GameObject firstCollisionObject = null;
        GameObject secondCollisionObject = null;
        for (GameObject g : myObjects){
            if (g.getIdentifier().getType().equals(myType) && g.isCollisionEnabled()){
                firstCollisionObject = g;
            }
            if (g.getIdentifier().getType().equals(mySecondType) && g.isCollisionEnabled()){
                secondCollisionObject = g;
            }
        }
        myCollision.fixedCollision(firstCollisionObject, secondCollisionObject);
        System.out.println("igothere");
    }
    
}
