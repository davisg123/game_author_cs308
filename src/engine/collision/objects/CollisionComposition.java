package engine.collision.objects;

import engine.gameObject.GameObject;
import engine.gameObject.components.PhysicsBody;

public class CollisionComposition {
	private static final double FRAMES_PER_SECOND = 60.0;

	public boolean isOnXAxis(GameObject one, GameObject two) {
		double xCenterOne = one.getPosition().getX();
		double yCenterOne = one.getPosition().getY();
		double xCenterTwo = two.getPosition().getX();
		double yCenterTwo = two.getPosition().getY();
		double widthOne = one.getPhysicsBody().getCollisionBodyWidth();
		double lengthOne = one.getPhysicsBody().getCollisionBodyHeight();
		double widthTwo = two.getPhysicsBody().getCollisionBodyWidth();
		double lengthTwo = two.getPhysicsBody().getCollisionBodyHeight();
		double xChange = 0.0;
		double yChange = 0.0;

		xChange = ((xCenterOne > yCenterOne) ? collisionHelper(xCenterOne,
				xCenterTwo, widthOne, widthTwo) : collisionHelper(xCenterTwo,
				xCenterOne, widthTwo, widthOne));
		yChange = ((yCenterOne > yCenterOne) ? collisionHelper(yCenterOne,
				yCenterTwo, lengthOne, lengthTwo) : collisionHelper(yCenterTwo,
				yCenterOne, lengthTwo, lengthOne));

		GameObject cur = ((one.getPhysicsBody().getVelocity().getMagnitude() == 0.0) ? two
				: one);
		GameObject second = (!(one.getPhysicsBody().getVelocity()
				.getMagnitude() == 0.0) ? two : one);
		double curX = cur.getPhysicsBody().getVelocity().getX();
		double curY = cur.getPhysicsBody().getVelocity().getY();
		double otherX = second.getPhysicsBody().getVelocity().getX();
		double otherY = second.getPhysicsBody().getVelocity().getY();
		// collides in x is true, y is false;
		// need to write this to return the proper thing, might need to be
		// corrected with old velocity
		return false;
		// (xChange / (Math.abs(curX)+Math.abs(otherX)) >yChange /
		// (Math.abs(curY)+Math.abs(otherY)));
	}

	public void fixedCollision(GameObject fixed, GameObject other) {

		// System.out.println(xChange / (Math.abs(curX)+Math.abs(otherX)));
		// create new condition to stop x or y
		boolean xAxis = isOnXAxis(fixed, other);

		if (!other.getCollisionConstant()) {

			if (xAxis) {

				// cancel out current velocity
				other.setTranslateX(other.getTranslateX()
						- other.getPhysicsBody().getVelocity().getX()
						/ FRAMES_PER_SECOND);
				// apply rivaling velocity
				other.setTranslateX(other.getTranslateX()
						+ other.getPhysicsBody().getVelocity().getX()
						/ FRAMES_PER_SECOND);
			} else {

				// cancel out current velocity
				other.setTranslateY(other.getTranslateY()
						- other.getPhysicsBody().getVelocity().getY()
						/ FRAMES_PER_SECOND);

				// apply rivaling velocity
				other.setTranslateY(other.getTranslateY()
						+ other.getPhysicsBody().getVelocity().getY()
						/ FRAMES_PER_SECOND);
			}
		}
	}

	private double collisionHelper(double centerOne, double centerTwo,
			double measureOne, double measureTwo) {
		return (centerTwo + measureTwo) - (centerOne - measureOne);
	}

	// currently a gameObject because i need the position, which isn't stored in
	// the physics body
	public void reverseVelocites(GameObject one, GameObject two) {
		boolean xAxis = isOnXAxis(one, two);
		one.getPhysicsBody().reverseVelocity(xAxis);
		two.getPhysicsBody().reverseVelocity(xAxis);
	}
}
