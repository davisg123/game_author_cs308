package engine.render;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import engine.FilePathUtility;
import engine.gameObject.*;
import engine.gameObject.components.PhysicsBody;
import engine.level.Level;

/**
 * Renders GameObjects on a given Canvas by generating 
 * JavaFX nodes and Images from state information 
 * 
 * @author Will Chang
 * @author Davis
 * 	
 */

public class GameObjectRenderer {
    private Group myCanvas;
    private Map<String, RenderedNode> myRenderedNodes;
    private Level myCurrentLevel;
    private static final String IMAGES = "images";
    private FilePathUtility myFilePathUtility;
    /**
     * Constructor takes in a group as the Canvas of the game 
     * @param canvas
     * @param relativePath 
     */
    public GameObjectRenderer (Group canvas, String relativePath) {
        myCanvas = canvas;
        myRenderedNodes = new HashMap<>();
        myFilePathUtility = new FilePathUtility(IMAGES,relativePath);
    }
    
    /**
     * Renders all GameObjects within a Level
     * @param level
     */
    public void renderGameObjects (Level level) {
        myCanvas.getChildren().clear();
        myCurrentLevel = level;
        for(Iterator<GameObject> iter = myCurrentLevel.getGameObjectIterator(); iter.hasNext();) {
            GameObject obj = iter.next();
            createAndAssignRenderedNode(obj);
        }
    }

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
        myCanvas.getChildren().add(node);
        obj.setRenderedNode(node);
    }

    /**
     * Creates the Image and ImageView for the RenderedNode if specified
     * @param obj
     * @return
     */
    private ImageView createImageAndView (GameObject obj) {
        String imageName = obj.getCurrentImageName();
        
        if(imageName != null) {
            FileInputStream in;
            try {
                in = new FileInputStream(myFilePathUtility.getFilePath()+imageName);
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
    private Node createCollisionBody (GameObject obj) {
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
    public void removeRenderedNode (String nodeID) {
        myRenderedNodes.remove(nodeID);
    }
}
