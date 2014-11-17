package engine.render;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import engine.level.Level;
import engine.sprite.*;
import gamePlayer.view.GameCanvas;

/**
 * Renders Sprites on a given Canvas by generating 
 * JavaFX nodes and Images from state information 
 * 
 * @author Will Chang
 * @author Davis
 *
 */

public class SpriteRenderer {
    //private GameCanvas myCanvas;
    private Group myCanvas;
    private Map<String, RenderedNode> myRenderedNodes;
    private Level myCurrentLevel;

    //Group Change to GameCanvas
    public SpriteRenderer (Group canvas) {
        myCanvas = canvas;
        myRenderedNodes = new HashMap<>();
    }

    
    
    //public void update?

    //Called once at the start of every level
    public void renderSprites (Level level) {
        //myCanvas.clear();
        myCanvas.getChildren().clear();
        myCurrentLevel = level;
        for(Iterator<Sprite> spriteIter = myCurrentLevel.getSprites(); spriteIter.hasNext();) {
            Sprite sprite = spriteIter.next();
            //String spriteID = sprite.getID();
            createAndAssignRenderedNode(sprite);
        }
    }

    //Set group to be at the center of the canvas to create a coordinate plane
    //Otherwise, set to the bottom lefthand corner
    //Need to use the Canvas dimensions
    //Change GameCanvas into a scene?
    public void createAndAssignRenderedNode (Sprite sprite) {
        RenderedNode node = new RenderedNode();
        node.setImageView(createImageAndView(sprite));
        node.setCollisionBody(createHitBox(sprite));
        node.setLayoutX(0);
        node.setLayoutY(0);
        node.setTranslateX(sprite.getDefaultPosition().getX());
        node.setTranslateY(sprite.getDefaultPosition().getY());
        node.setId(sprite.getID());
        myRenderedNodes.put(sprite.getID(), node);
        //TODO talk to Player group, ask them to change function call/functionality of Canvas
        //myCanvas.addToGroup(node);
        myCanvas.getChildren().add(node);
        sprite.setRenderedNode(node);
    }

    private ImageView createImageAndView(Sprite sprite) {
        String imagePath = sprite.getCurrentImagePath();
        
        if(imagePath != null) {  
            
            //This is total bullshit, but Image only searches the local package,
            //and ../ does not go to the directory above, have to set specific folders
            //and file paths inside the package that Sprite Renderer is located in...
            //Need to figure out workaround, URI's????
            Image image = new Image(getClass().getResourceAsStream(imagePath));
            ImageView view = new ImageView();
            view.setImage(image);
            view.setFitHeight(sprite.getHeight());
            view.setFitWidth(sprite.getWidth());
            view.setPreserveRatio(true);
            view.setSmooth(true);
            view.setCache(true);
            return view;
        }
        return null;
    }

    private Node createHitBox(Sprite sprite) {
        sprite.getPhysicsBody();
        //Temporary
        Rectangle asdf = new Rectangle(100,100);
        asdf.setVisible(false);
        return asdf;
    }

    public void removeRenderedNode(String nodeID) {
        //myCanvas.remove(myRenderedNodes.get(nodeID));
        myRenderedNodes.remove(nodeID);
    }
}
