package engine.level;

import java.util.Iterator;
import java.util.List;
import engine.conditions.Condition;
import engine.sprite.Sprite;

/**
 * A Level of the game. Contains all Sprites and Actions and coordinates their interactions
 * for linear progression through the game.
 * @author Will Chang
 *
 */

public class Level {

    private List<Sprite> mySprites;
    private List<Condition> myConditions;
    
    
    /**
     * Constructor
     * @param sprites
     * @param actions
     */
    public Level(List<Sprite> sprites, List<Condition> conditions) {
        mySprites = sprites;
        myConditions = conditions;
    }
    
    /**
     * Updates all Sprites and Actions.
     */
    public void update() {
        
    }
    
    public Iterator<Sprite> getSprites () {
        return mySprites.iterator();
    }
    public Iterator<Condition> getConditions () {
        return myConditions.iterator();
    }
}
