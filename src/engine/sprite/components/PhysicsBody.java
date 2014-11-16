package engine.sprite.components;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import engine.physics.Acceleration;
import engine.physics.BEngine;
import engine.physics.Force;
import engine.physics.Impulse;
import engine.physics.Mass;
import engine.physics.NormalUpdate;
import engine.physics.Vector;
import engine.physics.Velocity;

/**
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
	private List<Double> myBalancedForcesMag;

	public PhysicsBody() {
		myImpulses = new ArrayList<Impulse>();
		myAcceleration = new Acceleration(0, 0);
		myVelocity = new Velocity(0, 0);
		myMass = new Mass(0);
		myUpdate = new NormalUpdate();
		myActiveForces = new ArrayList<Force>();
		haveForcesChanged = false;
		myBalancedForcesMag = new ArrayList<Double>();
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

	public Vector getPositionChange() {
		doImpulses();
		if (haveForcesChanged) {
			balanceForces();
		}
		changeAcceleration();
		changeVelocity();
		// return changePosition
		return new Vector(myVelocity.getX() / FRAMES_PER_SECOND,
				myVelocity.getY() / FRAMES_PER_SECOND);
	}

	private void doImpulses() {
		for (Impulse cur : myImpulses) {
			myVelocity.delta(cur);
		}
	}

	private void balanceForces() {
		double x = 0.0;
		double y = 0.0;
		for (Force cur : myActiveForces) {
			x += cur.getX();
			y += cur.getY();
		}
		myBalancedForcesMag.set(0, x);
		myBalancedForcesMag.set(1, y);
		haveForcesChanged = false;
	}

	private void changeAcceleration() {
		myAcceleration = new Acceleration(myBalancedForcesMag.get(0)
				/ myMass.getValue(), myBalancedForcesMag.get(1)
				/ myMass.getValue());
	}

	private void changeVelocity() {
		myVelocity.delta(myAcceleration.getX() / FRAMES_PER_SECOND,
				myAcceleration.getY() / FRAMES_PER_SECOND);
	}

}