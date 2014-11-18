package engine.level;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import engine.collisionDetection.CollisionDetector;
import engine.conditions.Condition;
import engine.render.SpriteRenderer;
import engine.sprite.IEnabled;
import engine.sprite.Sprite;

/**
 * A Level of the game. Contains all Sprites and Actions and coordinates their interactions
 * for linear progression through the game.
 * @author Will Chang
 *
 */

public class Level {

    private List<Sprite> mySprites;
    //private List<Condition> myConditions;
    private Map<String, Boolean> myEnabledSprites;
    private Map<String, Boolean> myEnabledConditions;
    private SpriteRenderer myRenderer;
    private CollisionDetector myDetector;


    /**
     * Constructor 
     * @param EnabledSpritesMap
     * @param EnabledActionsMap
     */
    public Level(Map<String, Boolean> enabledSprites, Map<String, Boolean> enabledConditions) {
        myEnabledSprites = enabledSprites;
        myEnabledConditions = enabledConditions;
    }

    /**
     * Updates all Sprites.
     */
    public void update() {
        for(Sprite sprite : mySprites) {
            sprite.update();
        }
    }
    
    public void setEnabledSprites(List<Sprite> sprites) {
       for(Sprite sprite : sprites) {
           if(myEnabledSprites.get(sprite.getID())) {
               //sprite.enable(); ??
               //copy of???
               //Initialize the sprite to location???
               mySprites.add(sprite);
           }
       }
    }
/*
    public void setEnabled(String type, List<IEnabled> enabledObjects) {
        
        for(IEnabled enabledObject : enabledObjects) {
            if(myEnabledSprites.get(sprite.getID())
        }
    }*/
    
    public void setEnabledConditions(List<Condition> conditions) {
        for(Condition condition : conditions) {
            //if(myEnabledConditions.get(condition.getID()) {
                //TODO have Conditions Implement IEnabled
              //  condition.enable();
            //}
        }
    }

    public Iterator<Sprite> getSprites () {
        return mySprites.iterator();
    }
    
    /*public Iterator<Condition> getConditions () {
        return myConditions.iterator();
    }*/
}
