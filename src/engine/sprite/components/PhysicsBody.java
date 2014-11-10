package engine.sprite.components;

/**
 * 
 * @author ArihantJain
 *
 *This class holds Physical Information for a Sprite.
 *
 */
public class PhysicsBody {
    private double myVelocity;
    private double myMass;
    public PhysicsBody(double v, double m){
        myVelocity = v;
        myMass = m;
    }
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