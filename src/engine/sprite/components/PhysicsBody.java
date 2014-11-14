package engine.sprite.components;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import engine.physics.BEngine;
import engine.physics.NormalUpdate;

/**
 * 
 * @author ArihantJain
 *
 *         This class holds Physical Information for a Sprite.
 *
 */
public class PhysicsBody {
	private List<Double> myImpulse;
	private List<Double> myAcceleration;
	private List<Double> myVelocity;
	private double myGravityConstant;
	private double myMass;
	private NormalUpdate myUpdate;

	public PhysicsBody(List<Double> initialVelocity, double mass, double gravity) {
		myImpulse = new ArrayList<Double>();
		myAcceleration = new ArrayList<Double>();
		myVelocity = initialVelocity;
		myMass = mass;
		myGravityConstant = gravity;
		myUpdate = new NormalUpdate();
	}

	/**
	 * Sets Velocity of object
	 * 
	 * @param v
	 *            - new Velocity of object
	 */
	public void setVelocity(List<Double> v) {
		myVelocity = v;
	}

	/**
	 * Sets mass of object
	 * 
	 * @param m
	 *            - new Mass of object
	 */
	public void setMass(double m) {
		myMass = m;
	}

	/**
	 * Return X-Coordinate of Object
	 * 
	 * @return - Y coordinate of Object
	 */
	public List getVelocity() {
		return myVelocity;
	}

	/**
	 * Return Y-Coordinate of Object
	 * 
	 * @return - returns Y coordinate of Object
	 */
	public double getMass(double y) {
		return myMass;
	}

	public List<Double> getPositionChange() {
		// update velocity with impulse
		for (int i = 0; i < 2; i++) {
			double a = myVelocity.get(i);
			a += myUpdate.impulseAndVelocity(myImpulse.get(i), myMass);
			myVelocity.set(i, a);
		}

		// update velocity with acceleration
		for (int i = 0; i < 2; i++) {
			double a = myVelocity.get(i);
			a += myUpdate.calculateLinearChange(myAcceleration.get(i));
			myVelocity.set(i, a);
		}

		// find delta position
		List<Double> a=new ArrayList<Double>();
		for (int i = 0; i < 2; i++) {
			a.add(myUpdate.calculateLinearChange(myVelocity.get(i)));
		}
		return a;
	}
}