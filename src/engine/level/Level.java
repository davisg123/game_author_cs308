package engine.level;

import java.util.List;
import engine.actions.Action;
import engine.sprite.Sprite;

/**
 * A Level of the game. Contains all Sprites and Actions and coordinates their interactions
 * for linear progression through the game.
 * @author Will Chang
 *
 */

public class Level {

    private List<Sprite> mySprites;
    private List<Action> myActions;
    
    
    /**
     * Constructor
     * @param sprites
     * @param actions
     */
    public Level(List<Sprite> sprites, List<Action> actions) {
        mySprites = sprites;
        myActions = actions;
    }
    
    /**
     * Updates all Sprites and Actions.
     */
    public void update() {
        
    }
    
}
