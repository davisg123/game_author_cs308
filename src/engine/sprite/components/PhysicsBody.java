package engine.sprite.components;

import java.awt.geom.Point2D;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.shape.Circle;

/**
 * 
 * @author ArihantJain
 *
 *This class holds Physical Information for a Sprite.
 *
 */
public abstract class PhysicsBody {
    protected double myVelocity;
    protected double myMass;
    protected Point2D myLocation;
    protected double myHeight;
    protected double myWidth;
    protected List<Point2D> myPoints;
    protected Node myRenderedNode;



    public PhysicsBody (Point2D location, double height, double width, double v, double m, List<Double> sideLengths) {
        myLocation = location;
        myHeight = height;
        myWidth = width;
        myVelocity = v;
        myMass = m;	



    }


    public PhysicsBody (Point2D location, double height, double width) {
        myLocation = location;
        myHeight = height;
        myWidth = width;



    }
    public void createNode(){
        myRenderedNode = initializeNode();
    }

    protected abstract Node initializeNode();


    /**
     * Sets Velocity of object
     * 
     * @param v - new Velocity of object
     */
    public void setVelocity(double v){
        myVelocity = v;
    }

    /**
     * Sets mass of object
     * @param m - new Mass of object
     */
    public void setMass(double m){
        myMass = m;
    }

    /**
     * Return X-Coordinate of Object
     * 
     * @return -  Y coordinate of Object
     */
    public double getVelocity(){
        return myVelocity;
    }

    /**
     * Return Y-Coordinate of Object
     * 
     * @return - returns Y coordinate of Object
     */
    public double getMass(double y){
        return myMass;
    }





}