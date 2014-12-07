package engine.gameObject.components;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import engine.gameObject.GameObject;
import java.util.Map;
import engine.physics.Acceleration;
import engine.physics.BEngine;
import engine.physics.Buoyancy;
import engine.physics.CoefficientOfFriction;
import engine.physics.CollisionConstant;
import engine.physics.Density;
import engine.physics.Force;
import engine.physics.Friction;
import engine.physics.Gravity;
import engine.physics.GravityConstant;
import engine.physics.Impulse;
import engine.physics.Mass;
import engine.physics.NormalUpdate;
import engine.physics.Scalar;
import engine.physics.Vector;
import engine.physics.Velocity;
import engine.physics.Volume;

/**
 * 
 * @author Ben Reisner
 * 
 * @author ArihantJain
 *
 *         This class holds Physical Information for a Sprite.
 *
 */
public class PhysicsBody {
	private static final double FRAMES_PER_SECOND = 60.0;
	private List<Impulse> myImpulses;
	private Vector myAcceleration;
	private Vector myVelocity;
	private boolean haveForcesChanged;
	private Vector myBalancedForcesMag;
	private Map<String, Force> myActiveForces;
	private Map<String, Scalar> myConstants;
	private double myCollisionBodyWidth;
	private double myCollisionBodyHeight;

	public PhysicsBody() {
		this(0, 0);
	}

	public PhysicsBody(double collisionBodyWidth, double collisionBodyHeight) {
		myImpulses = new ArrayList<Impulse>();
		myAcceleration = new Acceleration();
		myVelocity = new Velocity();
		myActiveForces = new HashMap<String, Force>();
		myConstants = new HashMap<String, Scalar>();
		initializeMap();
		haveForcesChanged = false;
		myBalancedForcesMag = new Vector();
		myCollisionBodyWidth = collisionBodyWidth;
		myCollisionBodyHeight = collisionBodyHeight;
	}

	/**
	 * Sets Velocity of object
	 * 
	 * @param v
	 *            - new Velocity of object
	 */

	/*
	 * need to work out two things: hardcode Scalar... scalar-->probably need to
	 * initialize those to 0 too
	 */
	private void initializeMap() {
		myConstants
				.put("CoefficientOfFriction", new CoefficientOfFriction(0.0));
		myConstants.put("CollisionConstant", new CollisionConstant(0.0));
		myConstants.put("Density", new Density(1.0));
		myConstants.put("GravityConstant", new GravityConstant(1.0));
		myConstants.put("Volume", new Volume(1.0));
		myConstants.put("Mass", new Mass(1.0));
		myActiveForces.put("Gravity", new Gravity(0, 0,
				myConstants.get("Mass"), myConstants.get("GravityConstant")));
		myActiveForces.put(
				"Buoyancy",
				new Buoyancy(0, 0, myConstants.get("Volume"), myConstants
						.get("Density")));
		myActiveForces.put("Friction",
				new Friction(0, 0, myConstants.get("CoefficientOfFriction"),
						myConstants.get("Mass")));
	}

	public void setVelocity(Vector v) {
		myVelocity = v;
	}

	public void setAcceleration(Vector v) {
		myAcceleration = v;
	}

	/**
	 * 
	 * @return the velocity of the object
	 */
	public Vector getVelocity() {
		return myVelocity;
	}

	public Vector getAcceleration() {
		return myAcceleration;
	}

	/**
	 * makes a new acceleration vector based on the magnitude of the forces and
	 * the mass
	 */
	private void changeAcceleration() {
		myAcceleration.delta(
				myBalancedForcesMag.getX() / myConstants.get("Mass").getValue()
						/ FRAMES_PER_SECOND, myBalancedForcesMag.getY()
						/ myConstants.get("Mass").getValue()
						/ FRAMES_PER_SECOND);
	}

	/**
	 * changes velocity based on acceleration
	 */
	private void changeVelocity() {
		// System.out.println(myAcceleration.getX()/ FRAMES_PER_SECOND);
		myVelocity.delta(myAcceleration.getX() / FRAMES_PER_SECOND,
				myAcceleration.getY() / FRAMES_PER_SECOND);
	}

	/**
	 * getter for height of hitbox
	 * 
	 * @return height of hitbox
	 */
	public double getCollisionBodyHeight() {
		return myCollisionBodyHeight;
	}

	/**
	 * getter for width of hitbox
	 * 
	 * @return width of hitbox
	 */
	public double getCollisionBodyWidth() {
		return myCollisionBodyWidth;
	}

	/**
	 * updates all the physical vector characteristics for object
	 * 
	 * @Param - Game object to change things for
	 */
	public void updatePhysicalCharacteristics(GameObject sprite) {
		doImpulses();
		if (haveForcesChanged) {
			balanceForces();
		}
		changeAcceleration();
		changeVelocity();
		// return changePosition

		// sprite.setPosition(new Point2D.Double(myVelocity.getX()
		// / FRAMES_PER_SECOND, myVelocity.getY() / FRAMES_PER_SECOND));
		sprite.setTranslateX(sprite.getTranslateX() + myVelocity.getX()
				/ FRAMES_PER_SECOND);
		sprite.setTranslateY(sprite.getTranslateY() + myVelocity.getY()
				/ FRAMES_PER_SECOND);
	}

	/**
	 * goes through impulses, imparts them, clears all of them once they are all
	 * done
	 */
	private void doImpulses() {
		for (Impulse cur : myImpulses) {
			cur.scalarMultiplication(1.0 / myConstants.get("Mass").getValue());
			myVelocity.delta(cur);
		}
		myImpulses.clear();
	}

	
	public Scalar getScalar(String s){
		return myConstants.get(s);
	}
	
	public Force getForce(String s){
		try{
			return myActiveForces.get(s);
		} 
		catch(NullPointerException e){
			System.out.println("Not an active force");
			return null;
		}
	}
	
	
	
	
	/**
	 * balances forces-gives a vector of what the forces in each direction are,
	 * sets haveForcesChanged to false because this is called only when in the
	 * frame force are changed
	 */
	private void balanceForces() {
		double x = 0.0;
		double y = 0.0;
		for (Force cur : this.myActiveForces.values()) {
			x += cur.getX();
			y += cur.getY();
		}
		myBalancedForcesMag.setX(x);
		myBalancedForcesMag.setY(y);
		haveForcesChanged = false;
	}

	public void addForce(Force vector) {
		Iterator<String> itr = vector.iterator();
		while(itr.hasNext())
		{
			String cur=itr.next();
			vector.addOrChangeValue(myConstants.get(cur));
		}
		this.myActiveForces.put(vector.toString(), vector);
		haveForcesChanged = true;
	}

	public void addImpulse(Vector i) {
		this.myImpulses.add((Impulse) i);
	}

	public void addScalar(Scalar a) {
		myConstants.put(a.toString(), a);
		Iterator<String> itr = a.iterator();
		while (itr.hasNext()) {
			String cur = itr.next();
			myActiveForces.get(cur).addOrChangeValue(a);
		}
	}

	public void reverseVelocity(boolean xAxis) {
		if (xAxis) {
			setVelocity(new Velocity(-1.0 * myVelocity.getX(),
					myVelocity.getY()));
		} else {
			setVelocity(new Velocity(myVelocity.getX(), -1.0
					* myVelocity.getY()));
		}
	}

	/**
	 * deals with collisions-axis, deals with velocities and will properly move
	 * things that are intersecting
	 * 
	 * @param thisSprite
	 *            -the sprite dealing with the collision
	 * @param sprite
	 *            -the sprite that collides with this one
	 */
	public void handleCollision(GameObject thisSprite, GameObject sprite) {
		double xCenterOne = thisSprite.getPosition().getX();
		double yCenterOne = thisSprite.getPosition().getY();
		double xCenterTwo = sprite.getPosition().getX();
		double yCenterTwo = sprite.getPosition().getY();
		double widthOne = thisSprite.getPhysicsBody().getCollisionBodyWidth();
		double lengthOne = thisSprite.getPhysicsBody().getCollisionBodyHeight();
		double widthTwo = sprite.getPhysicsBody().getCollisionBodyWidth();
		double lengthTwo = sprite.getPhysicsBody().getCollisionBodyHeight();
		double xChange = 0.0;
		double yChange = 0.0;

		xChange = ((xCenterOne > yCenterOne) ? collisionHelper(xCenterOne,
				xCenterTwo, widthOne, widthTwo) : collisionHelper(xCenterTwo,
				xCenterOne, widthTwo, widthOne));
		yChange = ((yCenterOne > yCenterOne) ? collisionHelper(yCenterOne,
				yCenterTwo, lengthOne, lengthTwo) : collisionHelper(yCenterTwo,
				yCenterOne, lengthTwo, lengthOne));

		GameObject cur = ((thisSprite.getPhysicsBody().getVelocity()
				.getMagnitude() == 0.0) ? sprite : thisSprite);
		GameObject other = (!(thisSprite.getPhysicsBody().getVelocity()
				.getMagnitude() == 0.0) ? sprite : thisSprite);
		double curX = cur.getPhysicsBody().getVelocity().getX();
		double curY = cur.getPhysicsBody().getVelocity().getY();
		double otherX = other.getPhysicsBody().getVelocity().getX();
		double otherY = other.getPhysicsBody().getVelocity().getY();
		// collides in x is true, y is false;
		boolean xOrY = false;// (xChange / (Math.abs(curX)+Math.abs(otherX)) >
								// yChange / (Math.abs(curY)+Math.abs(otherY)));
		// System.out.println(xChange / (Math.abs(curX)+Math.abs(otherX)));
		// create new condition to stop x or y
		if (!cur.getCollisionConstant()) {

			if (xOrY) {
				System.out.println("COLLISOIN");

				// cancel out current velocity
				cur.setTranslateX(cur.getTranslateX()
						- cur.getPhysicsBody().getVelocity().getX()
						/ FRAMES_PER_SECOND);
				// apply rivaling velocity
				cur.setTranslateX(cur.getTranslateX()
						+ other.getPhysicsBody().getVelocity().getX()
						/ FRAMES_PER_SECOND);
			} else {

				// cancel out current velocity
				cur.setTranslateY(cur.getTranslateY()
						- cur.getPhysicsBody().getVelocity().getY()
						/ FRAMES_PER_SECOND);

				// apply rivaling velocity
				cur.setTranslateY(cur.getTranslateY()
						+ other.getPhysicsBody().getVelocity().getY()
						/ FRAMES_PER_SECOND);
			}
		}
	}

	/**
	 * 
	 * @param centerOne
	 *            -x or y of the first hitbox
	 * @param centerTwo
	 *            -x or y of the second hitbox
	 * @param measureOne
	 *            -height or width of first hitbox
	 * @param measureTwo
	 *            -height or width of second hitbox
	 * @return double associated with collisions
	 */
	private double collisionHelper(double centerOne, double centerTwo,
			double measureOne, double measureTwo) {
		return (centerTwo + measureTwo) - (centerOne - measureOne);
	}

}