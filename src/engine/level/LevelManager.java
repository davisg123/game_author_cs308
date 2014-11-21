package engine.level;

import java.util.Iterator;
import java.util.List;
import engine.collisionDetection.CollisionDetector;
import engine.conditions.Condition;
import engine.render.GameObjectRenderer;
import engine.gameObject.GameObject;

/**
 * Manages the Levels, and progression of the Game
 * @author Will Chang
 *
 */

public class LevelManager implements Iterable<Level> {
    private List<Level> myLevels;
    private List<GameObject> myGameObjects;
    private List<Condition> myConditions;
    private Level myCurrentLevel;
    private int myCurrentIndex;
    private GameObjectRenderer myRenderer;
    private CollisionDetector myDetector; 
    
    /**
     * Constructor for a level
     * @param sprites
     * @param levels
     * @param conditions
     * @param renderer
     * @param detector
     */
    public LevelManager (List<GameObject> sprites, List<Level> levels, List<Condition> conditions, 
                         GameObjectRenderer renderer, CollisionDetector detector) {
        myGameObjects = sprites;
        myLevels = levels;
        myConditions = conditions;
        myCurrentIndex = 0;
        myCurrentLevel = myLevels.get(myCurrentIndex);
        myRenderer = renderer;
        myDetector = detector;
    }
    
    /**
     * Iterates through the list of Levels in the managers
     */
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
    
    /**
     * Sets current Level and initializes
     * @param levelIndex
     */
    public void goToLevel (int levelIndex) {
        myCurrentLevel = myLevels.get(levelIndex);
        initializeCurrentLevel();
    }
    
    /**
     * Update call, updates the current level
     */
    public void update () {
        myCurrentLevel.update();
    }
    
    /**
     * Initializes the Current Level
     */
    public void initializeCurrentLevel() {
        myCurrentLevel.setEnabledGameObjects(myGameObjects);
        myCurrentLevel.setEnabledConditions(myConditions);
        myRenderer.renderGameObjects(myCurrentLevel);
    }
    
}
