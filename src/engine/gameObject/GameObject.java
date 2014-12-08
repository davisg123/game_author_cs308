package engine.gameObject;

import engine.gameObject.components.*;
import engine.render.RenderedNode;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.beans.property.DoubleProperty;
import javafx.scene.image.Image;

/**
 * This class initiates a list of components which are characteristics of the GameObject. 
 * @author Arihant Jain
 * @author Will Chang
 *
 */
public class GameObject implements IEnabled, Iterable<Component>, Identifiable{
    private List<Component> myComponents;
    private double myRotation;
    private String myCurrentImageName;
    private String myID;
    private PhysicsBody myPhysicsBody;

    private double myHeight;
    private double myWidth;

    private double myXCoord;
    private double myYCoord;
    private transient RenderedNode myRenderedNode;

    private boolean myCollision;

    private boolean enabled;

    //Holds onto the default data for reinitialization. 
    private DefaultData myDefaultData; 

    //identifier
    private Identifier myId;

    //Is it colliding with something
    private boolean collisionEnabled;


    /**
     * Constructors
     */
    public GameObject () {
        this("");
    }

    public GameObject (String iD) {
        this(new ArrayList<Component>(), "", 0, 0, 0, 0, 0, iD);
    }

    public GameObject (List<Component> components, String imageName, 
                       double x, double y, double height, double width, double rotation, String iD) {
        myComponents  = components;
        myCurrentImageName = imageName;
        myXCoord = x;
        myYCoord = y;
        myHeight = height;
        myWidth = width;
        myRotation = rotation;
        myID = iD;
        setDefaultData(); 
    }

    private void setDefaultData() {
        List<Component> defaultComponents= new ArrayList<Component>(); 
        if (myComponents != null){
            for (Component c: myComponents){
                defaultComponents.add(c.getClone());
            }
        }
        myDefaultData = new DefaultData(defaultComponents, myCurrentImageName, myXCoord, myYCoord,  
                                        myHeight, myWidth, myRotation); 
    }

    /**
     * Constructors Clone a given game Object
     * @param g
     */
    public GameObject (GameObject g){
        this(g.getComponents(), g.getCurrentImageName(), 
             g.getX(), g.getY(), g.getHeight(), g.getWidth(), g.getRotation(), g.getID());
    }

    public GameObject (GameObject g, double x, double y, String type){
        this(g.getComponents(), g.getCurrentImageName(), 
             x, y, g.getHeight(), g.getWidth(), g.getRotation(), type);
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
     * Sets Initial Location of GameObject
     * @param point - new Location Point
     */
    public void setX (double x) {
        myXCoord = x;
    }

    public void setY (double y) {
        myYCoord = y;
    }


    /**
     * Link this with the physics body in the future
     * @param width
     */
    public void setWidth (double width) {
        myWidth = width;   
    }

    public void setHeight (double height) {
        myHeight = height;
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

    public double getRotation(){
        return this.myRotation;
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

    public double getX () {
        return myXCoord;
    }

    public double getY () {
        return myYCoord;
    }

    public String getID () {
        return myID;
    }

    public void setID(String s){
        myID = s;
    }

    /**
     * Updates all components of GameObject
     * TODO Check if necessary... 
     */

    public void update () {
        if (myComponents != null){
            for(Component component : myComponents) {
                component.update(null);
            }
        }
        if (myPhysicsBody != null){
            myPhysicsBody.updatePhysicalCharacteristics(this);
        }
    }

    public void setRenderedNode(RenderedNode node) {
        myRenderedNode = node;
    }

    public RenderedNode getRenderedNode() {
        return myRenderedNode;
    }

    /**
     * Temporary Map based getter...
     * @param iD
     * @return
     */
    public Component getComponent (Identifier iD) {
        Component result = null;
        for(Component comp : myComponents){
            if(comp.getIdentifier() == iD){
                result = comp;
            }
        }
        return result;
    }

    public List<Component> getComponents(){
        return this.myComponents;
    }

    public void addComponent(Component comp){
        this.myComponents.add(comp);   
    }

    public void removeComponent(Component comp){
        this.myComponents.remove(comp);   
    }

    public String getCurrentImageName () { 
        return myCurrentImageName;
    }

    public void setCurrentImagePath (String imageName) { 
        myCurrentImageName = imageName;
        myRenderedNode.getImageView().setImage(new Image(getClass().getResourceAsStream(imageName)));
    }

    @Override
    public Iterator<Component> iterator () {
        return myComponents.iterator();
    }

    public void saveCurrentState() {
        myRotation = myRenderedNode.getRotate();
        myXCoord = myRenderedNode.getTranslateX();
        myYCoord = myRenderedNode.getTranslateY();
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

    public void enableCollision() {
        collisionEnabled = true;
    }

    public void disableCollision() {
        collisionEnabled = false;
    }

    public boolean isCollisionEnabled() {
        return collisionEnabled;
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

    public boolean getCollisionConstant() {
        return myCollision;
    }

    public String toString(){
        return myID;
    }

    public void reset(){
        myRotation=myDefaultData.getRotation();
        myXCoord=myDefaultData.getXCoordinate();
        myYCoord=myDefaultData.getYCoordinate();
        myCurrentImageName=myDefaultData.getImageName();
        myComponents.clear();
        for (Component c: myDefaultData.getComponents()){
            myComponents.add(c.getClone());
        }
    }

    @Override
    public void setIdentifier (Identifier myId) {
        this.myId = myId;
    }

    @Override
    public Identifier getIdentifier () {
        return myId;
    }

}