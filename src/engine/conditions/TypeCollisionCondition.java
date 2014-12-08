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

public class TypeCollisionCondition extends TimeCondition {
    
    private Map<String,Integer> myCollisionMap;
    private String firstCollisionType;
    private String secondCollisionType; 
    private GameObjectsCollection myGameObjects;
    

    public TypeCollisionCondition (List<Action> actions, String firstType, String secondType) {
        //initialize as a time condition that executes every frame
        super(actions,1,true);

    	firstCollisionType=firstType;
    	secondCollisionType=secondType;
    	
        myCollisionMap = new HashMap<String,Integer>();
    }
    
    @Override
    public void initialize(GameManager gameManager){
    	myGameObjects = gameManager.getLevelManager().getCurrentLevel().getGameObjectsCollection();
    	initializeActions(gameManager);
    }
    
    @Override
    protected void executeActions () {
        //see what collisions are active
        checkCollisions();
        //we need to highlight some objects in GameManager

        //need a method to not highlight the stuff now
    }
    
    private void checkCollisions(){
        myCollisionMap.clear();
    	for (GameObject firstObject: myGameObjects){
    		if (firstObject.getIdentifier().getType().equals(firstCollisionType)){
    			for (GameObject secondObject: myGameObjects){
    				if (secondObject.getIdentifier().getType().equals(secondCollisionType)){
    				    String uniqueCollisionIdentifier = firstObject.getIdentifier().getHash()+secondObject.getIdentifier().getHash();
    	                            String reverseCollisionIdentifier = secondObject.getIdentifier().getHash()+firstObject.getIdentifier().getHash();
    	                            boolean isDuplicate = myCollisionMap.containsKey(uniqueCollisionIdentifier) || myCollisionMap.containsKey(reverseCollisionIdentifier);    	                    
    				    if (!isDuplicate && firstObject.getRenderedNode().getBoundsInParent()
    					        .intersects(secondObject.getRenderedNode().getBoundsInParent())){
                                            //need to highlight the objects involved in the collision
    				            firstObject.enableCollision();
    				            secondObject.enableCollision();
    				            if (myActions != null){
                                                for (Action a: myActions){
                                                        a.execute(); 
                                                }
    				            }
                                            //need to unhighlight the objects in the collision
                                            firstObject.disableCollision();
                                            secondObject.disableCollision();
    					}
    				}
    			}
    		}
    	}
    }

   
}
