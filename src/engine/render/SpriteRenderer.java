package engine.render;
import java.util.List;
import javafx.scene.shape.Circle;
import engine.sprite.*;
import engine.sprite.components.Layout;

/**
 * turns sprites into javafx nodes
 * 
 * @author Davis
 *
 */

public class SpriteRenderer {
    public void renderSprites(List<Sprite> spriteList){
        for (Sprite s : spriteList){
            //Layout spriteLayout = s.getLayout();
            //everything is a circle in my simple game world
            Circle circle = new Circle();
            //circle.setCenterX(spriteLayout.getPosX());
            //circle.setCenterY(spriteLayout.getPosY());
            //circle.setRadius(spriteLayout.getSizeHeight());
            //s.setNode(circle);
        }
    }
}
