package engine.sprite;

import engine.render.RenderedNode;
import engine.sprite.components.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.beans.property.DoubleProperty;
import javafx.scene.image.Image;

/**
 * This class initiates a list of components which are characteristics of the sprite. 
 * @author Arihant Jain
 * @author Will Chang
 *
 */
public class Sprite implements IEnabled, Iterable<SpriteComponent>{
    private List<SpriteComponent> myComponents; 
    //Temporary solution for extension to use Images and Sounds
    //Create actions which update the image paths...
    //Maybe connect it with a properties file
    //Create an Image and Path manager that works with the Renderer
    //Place inside sprite or inside the renderer package?...
    //Will cause an error if path does not exist... 
    //Maybe create an image and a sound component?
    //Should we have specific component fields??
    //Rendering, Camera, Physics, Attributes/current state
    //Make it a state machine as well???s
    //private ImageReference myImages;
    //private SoundReference mySounds;

    //We have to have a default... default sprite values... somehow
    //Include this in constructor
    //private DoubleProperty myXPosition;
    //private DoubleProperty myYPosition;
    private double myRotation;
    private String myCurrentImagePath;
    private String myID;
    private PhysicsBody myPhysicsBody;

    //Potentially used to set size???... or can just extend Dimesion2D
    //private Dimension2D myDimension; 
    private double myHeight;
    private double myWidth;
    private Point2D myDefaultPosition;

    private transient RenderedNode myRenderedNode;


    //Should it be included in constructor?
    private boolean enabled;

    /**
     * Constructors
     */
    public Sprite () {
        this("");
    }

    public Sprite (String iD) {
        this(new ArrayList<SpriteComponent>(), "", new Point2D.Double(), 0, 0, 0, iD);
    }

    public Sprite (List<SpriteComponent> components, String imagePath, Point2D position, 
                   double height, double width, double rotation, String iD) {
        this(components, imagePath, new SoundReference(), position,
             height, width, rotation, iD);
    }

    public Sprite (List<SpriteComponent> components, String imagePath, SoundReference sounds, 
                   Point2D position, double height, double width, double rotation, String iD) {
        myComponents  = components;
        //myImages   = images;
        //mySounds   = sounds;
        myCurrentImagePath = imagePath;
        myDefaultPosition = position;
        myHeight = height;
        myWidth = width;
        myRotation = rotation;
        myID = iD;
    }



    /**
     * Sets X-Coordinate of Object
     * @param x - New X coordinate of Object
     */
    public void setTranslateX (double xCoord) {
        myRenderedNode.setTranslateX(xCoord);
    }

    /**
     * Sets Y-Coordinate of Object
     * @param y - New Y coordinate of Object
     */
    public void setTranslateY (double yCoord) {
        myRenderedNode.setTranslateY(yCoord);
    }

    public double getTranslateX () {
        return myRenderedNode.getTranslateX();
    }
    
    public double getTranslateY () {
        return myRenderedNode.getTranslateY();
    }
    
    /**
     * Sets Location of Sprite
     * @param point - new Location Point
     */
    public void setPosition (Point2D point) {
        myDefaultPosition = point;
    }

    /**
     * Sets Orientation of Sprite
     * @param orientation
     */
    public void setOrientation(double orientation) {
        myRenderedNode.setRotate(orientation);
    }

    /**
     * Gets the Orientation of Sprite
     * @return
     */
    public double getOrientation () {
        return myRenderedNode.getRotate();
    }

    /**
     * Deprecated, all transforms are performed on the node
     * Gets the x position property of the sprite (for listeners)
     */
    public DoubleProperty getXPositionProperty(){
        return null;
    }

    /**
     * Deprecated, all transforms are performed on the node
     * Gets the y position property of the sprite (for listeners)
     */
    public DoubleProperty getYPositionProperty(){
        return null;
    }

    /**
     * Gets the Position of Sprite
     * @return myPosition
     */
    public Point2D getPosition () {
        return new Point2D.Double(myRenderedNode.getTranslateX(),
                                  myRenderedNode.getTranslateY());
    }


    public void setDefaultPosition (Point2D position) {
        myDefaultPosition = position;
    }

    /**
     * Gets the Position of Sprite
     * @return myPosition
     */
    public Point2D getDefaultPosition () {
        return myDefaultPosition;
    }

    /*public ImageReference getImageReferences () {
        return myImages;
    }

    public SoundReference getSoundReferences () {
        return mySounds;
    }*/


    public String getID () {
        return myID;
    }

    /**
     * Updates all components of Sprite
     * TODO Check if necessary... 
     */
    /*
    public void update () {
        for(SpriteComponent component : myComponents) {
            component.update();
        }
    }*/

    public void setRenderedNode(RenderedNode node) {
        myRenderedNode = node;
    }

    /**
     * Temporary Map based getter...
     * @param iD
     * @return
     */
    public SpriteComponent getComponent (String iD) {
        return null;
    }

    public String getCurrentImagePath () { 
        return myCurrentImagePath;
    }

    public void setCurrentImagePath (String imagePath) { 
        myCurrentImagePath = imagePath;
        myRenderedNode.getImageView().setImage(new Image(getClass().getResourceAsStream(imagePath)));
    }

    @Override
    public Iterator<SpriteComponent> iterator () {
        return myComponents.iterator();
    }

    public void saveCurrentState() {

    }

    public void setPhysicsBody (PhysicsBody physicsBody) {
        myPhysicsBody = physicsBody;
    }

    public PhysicsBody getPhysicsBody () {
        return myPhysicsBody;
    }

    public double getHeight () {
        return myHeight;
    }

    public double getWidth () {
        return myWidth;
    }

    public void enable() {
        enabled = true;
    }

    public void disable() {
        enabled = false;
    }

    public boolean isEnabled() {
        return enabled;
    }
}