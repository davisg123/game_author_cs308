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
 * This class initiates a list of components which are characteristics of the sprite. 
 * @author Arihant Jain
 * @author Will Chang
 *
 */
public class GameObject implements IEnabled, Iterable<Component>, Identifiable{
    private List<Component> myComponents;
    //Maybe connect it with a properties file
    //Create an Image and Path manager that works with the Renderer
    //Will cause an error if path does not exist... 
    //private ImageReference myImages;
    //private SoundReference mySounds;

    //private DoubleProperty myXPosition;
    //private DoubleProperty myYPosition;
    private double myRotation;
    private String myCurrentImageName;
    private String myID;
    private PhysicsBody myPhysicsBody;

    //Potentially used to set size???... or can just extend Dimesion2D
    //private Dimension2D myDimension; 
    private double myHeight;
    private double myWidth;

    //refactor the Point2D
    //private transient Point2D myDefaultPosition;
    private double myXCoord;
    private double myYCoord;
    private transient RenderedNode myRenderedNode;

    //refactor this into the PhysicsBody
    private boolean myCollision;


    //Should it be included in constructor?
    private boolean enabled;
    
    //Holds onto the default data for reinitialization. 
    private DefaultData myDefaultData; 
    
    //identifier
    private Identifier myId;

    /**
     * Constructors
     */
    public GameObject () {
        this("");
    }

    public GameObject (String iD) {
        this(new ArrayList<Component>(), "", 0, 0, 0, 0, 0, iD);
    }

    public GameObject (List<Component> components, String imagePath, double x, double y, 
                       double height, double width, double rotation, String iD) {
        this(components, imagePath, new SoundReference(), x, y,
             height, width, rotation, iD);
    }

    public GameObject (List<Component> components, String imageName, SoundReference sounds, 
                       double x, double y, double height, double width, double rotation, String iD) {
        myComponents  = components;
        //myImages   = images;
        //mySounds   = sounds;
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

	public GameObject (GameObject g){
    	this(g.getComponents(), g.getCurrentImageName(), g.getX(), g.getY(), g.getHeight(), g.getWidth(), g.getRotation(), g.getID());
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

    /* public GameObject copy() {
        return new GameObject(this);
    }*/

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

    /**
     * Updates all components of GameObject
     * TODO Check if necessary... 
     */

    public void update () {
        if (myComponents != null){
            for(Component component : myComponents) {
                //component.update(this); Should include current Level???... 
                //update methods should be specific to each component...
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
    public Component getComponent (String iD) {
        //TODO - make this work.
        return this.myComponents.get(id);
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