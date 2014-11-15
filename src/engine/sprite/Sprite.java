package engine.sprite;

import engine.sprite.components.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.beans.property.DoubleProperty;

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
    private ImageReference myImages;
    private SoundReference mySounds;

    //We have to have a default... default sprite values... somehow
    //Include this in constructor
    private DoubleProperty myXPosition;
    private DoubleProperty myYPosition;
    private double  myOrientation;
    private String  myID;

    //Potentially used to set size???... or can just extend Dimesion2D
    private Dimension2D d;
    
    //TODO Interface???
    //Should it be included in constructor?
    private boolean enabled;

    /**
     * Constructors
     */
    public Sprite () {
        this(new ArrayList<SpriteComponent>(), new Point2D.Double(), 0);
    }

    public Sprite (List<SpriteComponent> components, Point2D position, double rotation) {
        this(new ArrayList<SpriteComponent>(), new ImageReference(), new SoundReference(), position, rotation);
    }

    public Sprite (List<SpriteComponent> components, ImageReference images, SoundReference sounds, 
                   Point2D position, double orientation) {
        myComponents  = components;
        myImages   = images;
        mySounds   = sounds;
        myXPosition.set(position.getX());
        myYPosition.set(position.getY());
        myOrientation = orientation;
    }



    /**
     * Sets X-Coordinate of Object
     * @param x - New X coordinate of Object
     */
    public void setX (double xCoord) {
        myXPosition.set(xCoord);
    }

    /**
     * Sets Y-Coordinate of Object
     * @param y - New Y coordinate of Object
     */
    public void setY (double yCoord) {
        myYPosition.set(yCoord);
    }


    /**
     * Sets Location of Sprite
     * @param point - new Location Point
     */
    public void setPosition (Point2D point) {
        myXPosition.set(point.getX());
        myYPosition.set(point.getY());
    }

    /**
     * Sets Orientation of Sprite
     * @param orientation
     */
    public void setOrientation(double orientation) {
        myOrientation = orientation;
    }

    /**
     * Gets the Orientation of Sprite
     * @return
     */
    public double getOrientation () {
        return myOrientation;
    }
    
    /**
     * Gets the x position property of the sprite (for listeners)
     */
    public DoubleProperty getXPositionProperty(){
        return myXPosition;
    }
    
    /**
     * Gets the y position property of the sprite (for listeners)
     */
    public DoubleProperty getYPositionProperty(){
        return myYPosition;
    }

    /**
     * Gets the Position of Sprite
     * @return myPosition
     */
    public Point2D getPosition () {
        return new Point2D.Double(myXPosition.get(),myYPosition.get());
    }

    public ImageReference getImageReferences () {
        return myImages;
    }

    public SoundReference getSoundReferences () {
        return mySounds;
    }


    public String getID () {
        return myID;
    }

    /**
     * Updates all components of Sprite
     * TODO Check if necessary... 
     */
    public void update () {
        for(SpriteComponent component : myComponents) {
            component.update();
        }
    }
    
    /**
     * Temporary Map based getter...
     * @param iD
     * @return
     */
    public SpriteComponent getComponent (String iD) {
        return null;
    }

    @Override
    public Iterator<SpriteComponent> iterator () {
        return myComponents.iterator();
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