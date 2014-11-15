package engine.render;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import engine.level.Level;
import engine.sprite.*;
import engine.sprite.components.Layout;
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
    private GameCanvas myCanvas;
    private Map<String, Node> myRenderedNodes;
    private Map<String, ImageView> myImageViews;
    private Map<String, Node> myHitBoxes;
    private Level myCurrentLevel;

    public SpriteRenderer () {

    }

    public SpriteRenderer (GameCanvas canvas) {
        myCanvas = canvas;
        myRenderedNodes = new HashMap<>();
        myImageViews = new HashMap<>();
        myHitBoxes = new HashMap<>();
    }

    //Before this is called in each keyframe in the primary timeline
    //All time based events/updates must update the states in all the sprites
    public void renderSprites () {        
        for (Iterator<Sprite> spriteIter = myCurrentLevel.getSprites(); spriteIter.hasNext();) {
            Sprite sprite = spriteIter.next();
            if(sprite.isEnabled()) {
                updateRenderedNode(myRenderedNodes.get(sprite.getID()), sprite);
            }
        }
    }

    private void updateRenderedNode(Node renderedNode, Sprite sprite) {
        
        //Include a check within Sprite that says it needs to be updated???
        Point2D position = sprite.getPosition();
        renderedNode.setTranslateX(position.getX());
        renderedNode.setTranslateY(position.getY());
        //rotates the node, must determine final implementation of Orientation
        //renderedNode.setRotate(sprite.getOrientation());
        //resizes the node
        //renderedNode.???()
        myImageViews.get(sprite.getID()).setImage(new Image(sprite.getImageReferences().getCurrentImage()));;

    }

    public void initializeNodesFrom(Level level) {
        myCanvas.clear();
        myCurrentLevel = level;
        for(Iterator<Sprite> spriteIter = level.getSprites(); spriteIter.hasNext();) {
            Sprite sprite = spriteIter.next();
            String spriteID = sprite.getID();
            createAndAssignRenderedNode(sprite);
        }
    }

    //Set group to be at the center of the canvas to create a coordinate plane
    //Otherwise, set to the bottom lefthand corner
    //Need to use the Canvas dimensions
    //Change GameCanvas into a scene?
    public void createAndAssignRenderedNode (Sprite sprite) {
        //Needs to be based off of the Default or current state of the sprite

        Group group = new Group();
        ImageView view = createImageAndView(sprite);
        Node hitbox = createHitBox(sprite);
        group.getChildren().addAll(view, hitbox);
        myImageViews.put(sprite.getID(), view);
        myHitBoxes.put(sprite.getID(), hitbox);
        myRenderedNodes.put(sprite.getID(), group);

        group.setLayoutX(0);
        group.setLayoutY(0);
        group.setTranslateX(sprite.getPosition().getX());
        group.setTranslateY(sprite.getPosition().getY());
        myRenderedNodes.put(sprite.getID(), group);
        //TODO talk to Player group, ask them to change function call/functionality of Canvas
        myCanvas.addToGroup(group);
    }

    private ImageView createImageAndView(Sprite sprite) {

        String imagePath = sprite.getImageReferences().getCurrentImage();
        //Refactor after discussing implementation, 
        //need to associate images with orientations somehow
        //Needs image files in a predefined location
        //This might need to throw errors
        ImageView view = new ImageView(new Image(imagePath));
        //Get the Dimensions from the Sprite...
        view.setFitHeight(100);
        view.setFitWidth(100);

        view.setPreserveRatio(true);
        view.setSmooth(true);
        view.setCache(true);
        return view;

    }

    private Node createHitBox(Sprite sprite) {
        //Refactor
        sprite.getComponent("physicsBody");
        //return a new node accordingly...
        return null;
    }

    public void removeRenderedNode(String nodeID) {
        //myCanvas.remove(myRenderedNodes.get(nodeID));
        myRenderedNodes.remove(nodeID);
        myImageViews.remove(nodeID);
        myHitBoxes.remove(nodeID);
    }
}
