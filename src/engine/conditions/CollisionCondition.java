package engine.conditions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import authoring.model.collections.GameObjectsCollection;
import javafx.scene.Node;
import engine.GameManager;
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
    
//    private GameObjectsCollection mySecondCollisionSet;
//    private Map<String,Integer> myCollisionMap;
    private String firstCollisionType;
    private String secondCollisionType; 
    

    public CollisionCondition (List<Action> actions, String firstType, String secondType) {
        //initialize as a time condition that executes every frame
    	
//        super(myActions,firstCollisionSet,1,true);
    	
    	myActions = actions;
    	firstCollisionType=firstType;
    	secondCollisionType=secondType;
    	myTargetFrameCount=1;
    	repeats=true;
    	
//        myCollisionMap = new HashMap<String,Integer>();
    }
    
    @Override
    public void initialize(GameManager gameManager){
    	myGameObjects = gameManager.getLevelManager().getCurrentLevel().getGameObjectsCollection();
    }
    
    @Override
    protected void executeActions () {
        //see what collisions are active
        checkCollisions();
        //we need to highlight some objects in GameManager

        //need a method to not highlight the stuff now
    }
    
//    private void checkCollisions() {
//        myCollisionMap.clear();
//        for(GameObject innerGameObject : getGameObjects()) {
//            for(GameObject outerGameObject : mySecondCollisionSet) {
//                //Update the equals method, implement comparable
//                if(!outerGameObject.getID().equals(innerGameObject.getID())) {
//                    //Do intersect sequence
//                    //make sure the opposite collision hasn't already happened (a with b == b with a)
//                    String uniqueCollisionIdentifier = innerGameObject.getID()+outerGameObject.getID();
//                    String reverseCollisionIdentifier = outerGameObject.getID()+innerGameObject.getID();
//                    boolean isDuplicate = myCollisionMap.containsKey(uniqueCollisionIdentifier) || myCollisionMap.containsKey(reverseCollisionIdentifier);
//                    if(outerGameObject.getRenderedNode().getBoundsInParent().intersects(innerGameObject.getRenderedNode().getBoundsInParent()) 
//                            && !isDuplicate){
//                        outerGameObject.getPhysicsBody().handleCollision(outerGameObject, innerGameObject);
//                        myCollisionMap.put(uniqueCollisionIdentifier, 1);
//                    }
//                }
//            }
//        }
//    }
    
//    private void checkCollisions(){
//    	for (GameObject firstObject: myGameObjects){
//    		if (firstObject.getIdentifier().getType().equals(firstCollisionType)){
//    			for (GameObject secondObject: myGameObjects){
//    				if (secondObject.getIdentifier().getType().equals(secondCollisionType)){
//    					//check collision
//    					//need to highlight the objects involved in the collision
//    					for (Action a: myActions){
//    						a.execute(); 
//    					}
//    					//need to unhighlight the objects in the collision
//    				}
//    				
//    			}
//    			
//    		}
//    		
//    	}
//    	
//    }

   
}
