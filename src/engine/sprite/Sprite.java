package engine.sprite;

import engine.sprite.components.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    private Point2D myPosition;
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
        myPosition    = position;
        myOrientation = orientation;
    }



    /**
     * Sets X-Coordinate of Object
     * @param x - New X coordinate of Object
     */
    public void setX (double xCoord) {
        myPosition.setLocation(xCoord, myPosition.getY());
    }

    /**
     * Sets Y-Coordinate of Object
     * @param y - New Y coordinate of Object
     */
    public void setY (double yCoord) {
        myPosition.setLocation(myPosition.getX(), yCoord);
    }


    /**
     * Sets Location of Sprite
     * @param point - new Location Point
     */
    public void setPosition (Point2D point) {
        myPosition.setLocation(point);
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
     * Gets the Position of Sprite
     * @return myPosition
     */
    public Point2D getPosition () {
        return myPosition;
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