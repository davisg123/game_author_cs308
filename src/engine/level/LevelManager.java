package engine.level;

import java.util.Iterator;
import java.util.List;
import engine.render.SpriteRenderer;

/**
 * Manages the Levels of the Game
 * @author Will Chang
 *
 */

public class LevelManager implements Iterable<Level> {
    private List<Level> myLevels;
    private Level myCurrentLevel;
    private int myCurrentIndex;
    private SpriteRenderer myRenderer;
    
    public LevelManager (List<Level> levels, SpriteRenderer renderer) {
        myLevels = levels;
        myCurrentIndex = 0;
        myCurrentLevel = myLevels.get(myCurrentIndex);
        myRenderer = renderer;
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
    
    public void initializeCurrentLevel() {
        myRenderer.renderSprites(myCurrentLevel);
    }
    
}
