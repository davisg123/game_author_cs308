package engine.render;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import engine.gameObject.*;
import engine.gameObject.components.PhysicsBody;
import engine.level.Level;
import gamePlayer.view.GameCanvas;

/**
 * Renders GameObjects on a given Canvas by generating 
 * JavaFX nodes and Images from state information 
 * 
 * @author Will Chang
 * @author Davis
 * 	
 */

public class GameObjectRenderer {
    //private GameCanvas myCanvas;
    private Group myCanvas;
    private Map<String, RenderedNode> myRenderedNodes;
    private Level myCurrentLevel;
    private static final String SLASH = "/";
    private static final String DOT = ".";
    private static final String IMAGES = "images";
    private static String BASE_ASSET_PATH;
    private static final String ASSET_MAP_NAME = "asset_map";

    //Group Change to GameCanvas
    /**
     * Constructor takes in a group as the Canvas of the game 
     * @param canvas
     * @param relativePath 
     */
    public GameObjectRenderer (Group canvas, String relativePath) {
        myCanvas = canvas;
        myRenderedNodes = new HashMap<>();
        BASE_ASSET_PATH = relativePath;
    }

    //Called once at the start of every level
    //TODO move this to a Condition/Action pair???
    /**
     * Renders all GameObjects within a Level
     * @param level
     */
    public void renderGameObjects (Level level) {
        //myCanvas.clear();
        myCanvas.getChildren().clear();
        myCurrentLevel = level;
        for(Iterator<GameObject> iter = myCurrentLevel.getGameObjectIterator(); iter.hasNext();) {
            GameObject obj = iter.next();
            //String spriteID = sprite.getID();
            createAndAssignRenderedNode(obj);
        }
    }

    //Set group to be at the center of the canvas to create a coordinate plane
    //Otherwise, set to the bottom lefthand corner
    //Need to use the Canvas dimensions
    //Change GameCanvas into a scene?
    /**
     * Generates the JavaFX Node for a GameObject, giving it its image and CollisionBody
     * 
     * @param obj
     */
    public void createAndAssignRenderedNode (GameObject obj) {
        RenderedNode node = new RenderedNode();
        node.setImageView(createImageAndView(obj));
        node.setCollisionBody(createCollisionBody(obj));
        node.setLayoutX(0);
        node.setLayoutY(0);
        node.setTranslateX(obj.getX());
        node.setTranslateY(obj.getY());
        node.setId(obj.getID());
        myRenderedNodes.put(obj.getID(), node);
        //TODO talk to Player group, ask them to change function call/functionality of Canvas
        //myCanvas.addToGroup(node);
        myCanvas.getChildren().add(node);
        obj.setRenderedNode(node);
    }

    /**
     * Creates the Image and ImageView for the RenderedNode if specified
     * @param obj
     * @return
     */
    private ImageView createImageAndView(GameObject obj) {
        String imageName = obj.getCurrentImageName();
        
        if(imageName != null) {  
            //convert image name to a filepath using the asset_map
            System.out.println(BASE_ASSET_PATH+SLASH+IMAGES+SLASH+imageName);
            FileInputStream in;
            try {
                in = new FileInputStream(BASE_ASSET_PATH+SLASH+IMAGES+SLASH+imageName);
                Image image = new Image(in);
                ImageView view = new ImageView();
                view.setImage(image);
                view.setFitHeight(obj.getHeight());
                view.setFitWidth(obj.getWidth());
                view.setPreserveRatio(true);
                view.setSmooth(true);
                view.setCache(true);
                return view;
            }
            catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * Creates the CollisionBody of the GameObject
     * @param sprite
     * @return
     */
    private Node createCollisionBody(GameObject obj) {
        //Temporary
        PhysicsBody body = obj.getPhysicsBody();
        Rectangle asdf = new Rectangle(body.getCollisionBodyHeight(),body.getCollisionBodyWidth());
        asdf.setVisible(false);
        return asdf;
    }

    /**
     * Removes a rendered Node from the list of currently rendered Nodes
     * @param nodeID
     */
    public void removeRenderedNode(String nodeID) {
        //myCanvas.remove(myRenderedNodes.get(nodeID));
        myRenderedNodes.remove(nodeID);
    }
}
