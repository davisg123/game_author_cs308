package engine.level;

import java.util.Iterator;
import java.util.List;
import engine.conditions.ButtonConditionManager;
import engine.conditions.MovementCondition;
import engine.sprite.Sprite;

/**
 * A Level of the game. Contains all Sprites and Actions and coordinates their interactions
 * for linear progression through the game.
 * @author Will Chang
 *
 */

public class Level {

    private List<Sprite> mySprites;
    private List<MovementCondition> myConditions;
    private ButtonConditionManager myButtonConditionManager;
    
    
    /**
     * Constructor
     * @param sprites
     * @param actions
     */
    public Level(List<Sprite> sprites, List<MovementCondition> conditions, ButtonConditionManager buttonManager) {
        mySprites = sprites;
        myConditions = conditions;
        myButtonConditionManager = buttonManager;
    }
    
    /**
     * Updates all Sprites and Actions.
     */
    public void update() {
        
    }
    
    public Iterator<Sprite> getSprites () {
        return mySprites.iterator();
    }
    public Iterator<MovementCondition> getConditions () {
        return myConditions.iterator();
    }
}
