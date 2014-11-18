package engine.level;

import java.util.Iterator;
import java.util.List;
import engine.collisionDetection.CollisionDetector;
import engine.conditions.Condition;
import engine.render.SpriteRenderer;
import engine.sprite.Sprite;

/**
 * Manages the Levels of the Game
 * @author Will Chang
 *
 */

public class LevelManager implements Iterable<Level> {
    private List<Level> myLevels;
    private List<Sprite> mySprites;
    private List<Condition> myConditions;
    private Level myCurrentLevel;
    private int myCurrentIndex;
    private SpriteRenderer myRenderer;
    private CollisionDetector myDetector;
    
    
    
    public LevelManager (List<Sprite> sprites, List<Level> levels, List<Condition> conditions, 
                         SpriteRenderer renderer, CollisionDetector detector) {
        mySprites = sprites;
        myLevels = levels;
        myConditions = conditions;
        myCurrentIndex = 0;
        myCurrentLevel = myLevels.get(myCurrentIndex);
        myRenderer = renderer;
        myDetector = detector;
    }
    
    public Iterator<Level> iterator () {
        return myLevels.iterator();
    }
    
    /**
     * Primitive implementation of level loop...
     */
    public void nextLevel () {
        if(myCurrentIndex < myLevels.size() - 1) {
            myCurrentIndex += 1;
            myCurrentLevel = myLevels.get(myCurrentIndex);
        }
        else {
            myCurrentIndex = 0;
        }
    }
    
    public void goToLevel (int levelIndex) {
        myCurrentLevel = myLevels.get(levelIndex);
        initializeCurrentLevel();
    }
    
    public void update () {
        myCurrentLevel.update();
    }
    
    public void initializeCurrentLevel() {
        myCurrentLevel.setEnabledSprites(mySprites);
        myCurrentLevel.setEnabledConditions(myConditions);
        myRenderer.renderSprites(myCurrentLevel);
    }
    
}
