package engine.events;

import java.util.List;
import engine.sprite.Sprite;

/**
 * Does rendering for all Sprites.
 * @author Will
 *
 */

public class RenderEvent implements Event {

    private List<Sprite> mySprites;
    
    public RenderEvent (List<Sprite> sprites) {
        mySprites = sprites;
    }

    @Override
    public void execute () {
        // TODO Auto-generated method stub

    }

}
