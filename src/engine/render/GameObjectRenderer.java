package engine.render;
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
    private static ResourceBundle ourAssetMapBundle;
    private static final String SLASH = "/";
    private static final String DOT = ".";
    private static final String BASE_ASSET_PATH = "assets";
    private static final String ASSET_MAP_NAME = "asset_map";

    //Group Change to GameCanvas
    public GameObjectRenderer (Group canvas) {
        myCanvas = canvas;
        myRenderedNodes = new HashMap<>();
        ourAssetMapBundle = ResourceBundle.getBundle(BASE_ASSET_PATH+DOT+ASSET_MAP_NAME);
    }

    
    
    //public void update?

    //Called once at the start of every level
    public void renderGameObjects (Level level) {
        //myCanvas.clear();
        myCanvas.getChildren().clear();
        myCurrentLevel = level;
        for(Iterator<GameObject> iter = myCurrentLevel.getGameObjects(); iter.hasNext();) {
            GameObject obj = iter.next();
            //String spriteID = sprite.getID();
            createAndAssignRenderedNode(obj);
        }
    }

    //Set group to be at the center of the canvas to create a coordinate plane
    //Otherwise, set to the bottom lefthand corner
    //Need to use the Canvas dimensions
    //Change GameCanvas into a scene?
    public void createAndAssignRenderedNode (GameObject obj) {
        RenderedNode node = new RenderedNode();
        node.setImageView(createImageAndView(obj));
        node.setCollisionBody(createHitBox(obj));
        node.setLayoutX(0);
        node.setLayoutY(0);
        node.setTranslateX(obj.getDefaultPosition().getX());
        node.setTranslateY(obj.getDefaultPosition().getY());
        node.setId(obj.getID());
        myRenderedNodes.put(obj.getID(), node);
        //TODO talk to Player group, ask them to change function call/functionality of Canvas
        //myCanvas.addToGroup(node);
        myCanvas.getChildren().add(node);
        obj.setRenderedNode(node);
    }

    private ImageView createImageAndView(GameObject sprite) {
        String imageName = sprite.getCurrentImageName();
        
        if(imageName != null) {  
            //convert image name to a filepath using the asset_map
            String filepath = ourAssetMapBundle.getString(imageName);
            Image image = new Image(getClass().getResourceAsStream(SLASH+BASE_ASSET_PATH+SLASH+filepath));
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

    private Node createHitBox(GameObject sprite) {
        //Temporary
        PhysicsBody body = sprite.getPhysicsBody();
        Rectangle asdf = new Rectangle(body.getCollisionBodyHeight(),body.getCollisionBodyWidth());
        asdf.setVisible(false);
        return asdf;
    }

    public void removeRenderedNode(String nodeID) {
        //myCanvas.remove(myRenderedNodes.get(nodeID));
        myRenderedNodes.remove(nodeID);
    }
}
