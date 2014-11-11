package engine;
import java.util.List;
import engine.conditions.*;
import engine.render.SpriteRenderer;
import engine.sprite.*;

/**
 * 
 * @author Davis
 *
 */

public class GameManager {
    private List<Condition> myGameConditions;
    private List<Sprite> myGameSprites;
    private SpriteRenderer mySpriteRenderer;
    
    
    
    public GameManager (List<Condition> myGameConditions, List<Sprite> myGameSprites) {
        super();
        this.myGameConditions = myGameConditions;
        this.myGameSprites = myGameSprites;
        renderSprites();
    }
    
    private void renderSprites(){
        SpriteRenderer mySpriteRenderer = new SpriteRenderer();
        mySpriteRenderer.renderSprites(myGameSprites);
    }

    /**
     * run updates on every sprite and every condition
     */
    public void processFrame(){
        System.out.println("frame");
    }
}
