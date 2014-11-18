package engine.sprite.components;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import engine.physics.Acceleration;
import engine.physics.BEngine;
import engine.physics.Force;
import engine.physics.Impulse;
import engine.physics.Mass;
import engine.physics.NormalUpdate;
import engine.physics.Vector;
import engine.physics.Velocity;
import engine.sprite.Sprite;

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
	private List<Force> myActiveForces;
	private List<Double> myNetForce;
	private Acceleration myAcceleration;
	private Velocity myVelocity;
	private Mass myMass;
	private NormalUpdate myUpdate;
	private boolean haveForcesChanged;
	private Vector myBalancedForcesMag;

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
		myAcceleration = new Acceleration(0, 0);
		myVelocity = new Velocity(0, 0);
		myMass = new Mass(0);
		myUpdate = new NormalUpdate();
		myActiveForces = new ArrayList<Force>();
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
	public void setVelocity(Velocity v) {
		myVelocity = v;
	}

	/**
	 * Sets mass of object
	 * 
	 * @param m
	 *            - new Mass of object
	 */
	public void setMass(Mass m) {
		myMass = m;
	}

	/**
	 * Return X-Coordinate of Object
	 * 
	 * @return - Y coordinate of Object
	 */
	public Velocity getVelocity() {
		return myVelocity;
	}

	/**
	 * Return Y-Coordinate of Object
	 * 
	 * @return - returns Y coordinate of Object
	 */
	public Mass getMass(double y) {
		return myMass;
	}

	public void getPositionChange(Sprite sprite) {
		doImpulses();
		if (haveForcesChanged) {
			balanceForces();
		}
		changeAcceleration();
		changeVelocity();
		// return changePosition

		sprite.setPosition(new Point2D.Double(myVelocity.getX()
				/ FRAMES_PER_SECOND, myVelocity.getY() / FRAMES_PER_SECOND));
	}

	private void doImpulses() {
		for (Impulse cur : myImpulses) {
			cur.scalarMultiplication(1.0 / myMass.getValue());
			myVelocity.delta(cur);
		}
		myImpulses.clear();
	}

	private void balanceForces() {
		double x = 0.0;
		double y = 0.0;
		for (Force cur : myActiveForces) {
			x += cur.getX();
			y += cur.getY();
		}
		myBalancedForcesMag.setX(x);
		myBalancedForcesMag.setY(y);
		haveForcesChanged = false;
	}

	private void changeAcceleration() {
		myAcceleration = new Acceleration(myBalancedForcesMag.getX()
				/ myMass.getValue(), myBalancedForcesMag.getY()
				/ myMass.getValue());
	}

	private void changeVelocity() {
		myVelocity.delta(myAcceleration.getX() / FRAMES_PER_SECOND,
				myAcceleration.getY() / FRAMES_PER_SECOND);
	}

	public double getCollisionBodyHeight() {
		return myCollisionBodyHeight;
	}

	public double getCollisionBodyWidth() {
		return myCollisionBodyWidth;
	}

	public void handleCollision(Sprite thisSprite, Sprite sprite) {
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

		Sprite cur = ((thisSprite.getPhysicsBody().getVelocity().getMagnitude() == 0.0) ? sprite
				: thisSprite);
		Sprite other = (!(thisSprite.getPhysicsBody().getVelocity()
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

	private double collisionHelper(double centerOne, double centerTwo,
			double measureOne, double measureTwo) {
		return (centerTwo + measureTwo) - (centerOne - measureOne);
	}

}