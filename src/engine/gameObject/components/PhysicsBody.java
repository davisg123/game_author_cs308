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
	private Map<String, Force> myActiveForces;
	private Vector myAcceleration;
	private Vector myVelocity;
	private boolean haveForcesChanged;
	private Vector myBalancedForcesMag;
	private Map<String, Scalar> myConstants;
	// Temorary, initial implementation and location
	// of the collision body as rectangular shape is in Physics Body,
	// will refactor later to Polygon/Circle and place into proper place
	// with relation to RenderedNode
	private double myCollisionBodyWidth;
	private double myCollisionBodyHeight;

	public PhysicsBody() {
		this(0, 0);
	}

	public PhysicsBody(double collisionBodyWidth, double collisionBodyHeight) {
		myImpulses = new ArrayList<Impulse>();
		myAcceleration = new Vector();
		myVelocity = new Vector();
		// myUpdate = new NormalUpdate();
		myActiveForces = new HashMap<String, Force>();
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
		myActiveForces.put("gravity", new Gravity(0, 0, new Mass(1), new GravityConstant(1)));
		myActiveForces.put("buoyancy", new Buoyancy(0, 0, new Volume(1), new Density(1)));
		myActiveForces.put("friction", new Friction(0, 0, new CoefficientOfFriction(1), new Mass(1)));
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
		myAcceleration = new Acceleration(myBalancedForcesMag.getX()
				/ myConstants.get("Mass").getValue(),
				myBalancedForcesMag.getY() / myConstants.get("Mass").getValue());
	}

	/**
	 * changes velocity based on acceleration
	 */
	private void changeVelocity() {
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

		sprite.setX(myVelocity.getX() / FRAMES_PER_SECOND);
		sprite.setY(myVelocity.getY() / FRAMES_PER_SECOND);
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

	public void addForce(Force f) {
		if (this.myActiveForces.containsKey(f.toString())) {
			this.myActiveForces.replace(f.toString(), f);
		} else {
			this.myActiveForces.put(f.toString(), f);
		}
	}

	public void addImpulse(Impulse i) {
		this.myImpulses.add(i);
	}

	public void addScalar(Scalar a) {
		myConstants.put(a.toString(), a);
		Iterator<String> itr = a.iterator();
		while (itr.hasNext()) {
			String cur = itr.next();
			myActiveForces.get(cur).addOrChangeValue(a);
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
		// collides in x is true, y is false;
		boolean xOrY = (xChange / curX > yChange / curY);

		// create new condition to stop x or y
		if (!cur.getCollisionConstant()) {
			if (xOrY) {
				cur.getPhysicsBody().setVelocity(
						new Velocity(0.0, cur.getPhysicsBody().getVelocity()
								.getY()));
			} else {
				cur.getPhysicsBody().setVelocity(
						new Velocity(cur.getPhysicsBody().getVelocity().getX(),
								0.0));

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