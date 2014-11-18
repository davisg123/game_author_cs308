package engine.actions;

import java.util.List;
import engine.sprite.Sprite;

/**
 * Does rendering for all Sprites.
 * @author Will
 *
 */

public class RenderAction implements Action {

    private List<Sprite> mySprites;
    
    public RenderAction (List<Sprite> sprites) {
        mySprites = sprites;
    }

    @Override
    public void execute () {
        // TODO Auto-generated method stub

    }

}
