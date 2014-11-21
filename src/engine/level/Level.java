package engine.level;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import engine.collisionDetection.CollisionDetector;
import engine.conditions.Condition;
import engine.gameObject.IEnabled;
import engine.gameObject.GameObject;
import engine.render.GameObjectRenderer;

/**
 * A Level of the game. Contains all GameObjects and Actions and coordinates their interactions
 * for linear progression through the game.
 * @author Will Chang
 *
 */

public class Level {

    private List<GameObject> myGameObjects;
    //private List<Condition> myConditions;
    private Map<String, Boolean> myEnabledGameObjects;
    private Map<String, Boolean> myEnabledConditions;
    private GameObjectRenderer myRenderer;
    private CollisionDetector myDetector;


    /**
     * Constructor 
     * @param EnabledGameObjectsMap
     * @param EnabledActionsMap
     */
    public Level(Map<String, Boolean> enabledGameObjects, Map<String, Boolean> enabledConditions) {
        myEnabledGameObjects = enabledGameObjects;
        myEnabledConditions = enabledConditions;
    }

    /**
     * Updates all GameObjects.
     */
    public void update() {
        for(GameObject sprite : myGameObjects) {
            sprite.update();
        }
    }
    
    /**
     * Enables and initializes the Game Objects specified in this Level
     * 
     * @param sprites
     */
    public void setEnabledGameObjects(List<GameObject> sprites) {
       for(GameObject sprite : sprites) {
           if(myEnabledGameObjects.get(sprite.getID())) {
               //sprite.enable(); ??
               //copy of???
               //Initialize the sprite to location???
               myGameObjects.add(sprite);
           }
       }
    }
/*
    public void setEnabled(String type, List<IEnabled> enabledObjects) {
        
        for(IEnabled enabledObject : enabledObjects) {
            if(myEnabledGameObjects.get(sprite.getID())
        }
    }*/
    
    /**
     * Enables the Conditions specified in this Level
     * @param conditions
     */
    public void setEnabledConditions(List<Condition> conditions) {
        for(Condition condition : conditions) {
            //if(myEnabledConditions.get(condition.getID()) {
                //TODO have Conditions Implement IEnabled
              //  condition.enable();
            //}
        }
    }

    /**
     * Iterator for the List of enabled Game Objects in the Level
     * @return
     */
    public Iterator<GameObject> getGameObjects () {
        return myGameObjects.iterator();
    }
    
    /*public Iterator<Condition> getConditions () {
        return myConditions.iterator();
    }*/
}
