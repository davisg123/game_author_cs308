package engine.gameObject.components;

import java.awt.geom.Point2D;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import engine.gameObject.GameObject;
import java.util.Map;
import engine.physics.Acceleration;
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
 *         This class holds Physical Information for a GameObject.
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

	public PhysicsBody(double collisionBodyHeight, double collisionBodyWidth) {
		myImpulses = new ArrayList<Impulse>();
		myAcceleration = new Acceleration();
		myVelocity = new Velocity();
		myActiveForces = new HashMap<String, Force>();
		myConstants = new HashMap<String, Scalar>();
		initializeMap();
		myBalancedForcesMag = new Vector();
		balanceForces();
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
		/*
		 * myConstants .put("CoefficientOfFriction", new
		 * CoefficientOfFriction(0.0));
		 */
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
		/*
		 * myActiveForces.put("Friction", new Friction(0, 0,
		 * myConstants.get("CoefficientOfFriction"), myConstants.get("Mass")));
		 */
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

	public Scalar getScalar(String s) {
		try {
			return myConstants.get(s);
		} catch (NullPointerException e) {
			return null;
		}
	}

	/**
	 * updates all the physical vector characteristics for object
	 * 
	 * @Param - Game object to change things for
	 */
	// doesn't change the sprites physics body because this is the sprites
	// physics body, gameobject is passed through because I was told to do that
	// to solve the x/y coordinates being elsewhere problem
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
		if (sprite.getID().equals("ball_object")) {
			System.out.println(sprite.getRenderedNode().getBoundsInParent()
					.getHeight()+" "+sprite.getRenderedNode().getBoundsInParent()
					.getWidth());
		}
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

	public Force getForce(String s) {
		try {
			return myActiveForces.get(s);
		} catch (NullPointerException e) {
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
	}

	public void addForce(Force vector) {
		Iterator<String> itr = vector.iterator();
		while (itr.hasNext()) {
			String cur = itr.next();
			vector.addOrChangeValue(myConstants.get(cur));
		}
		this.myActiveForces.put(vector.toString(), vector);
		balanceForces();
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
		balanceForces();
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

}