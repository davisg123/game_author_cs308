package engine.collision.objects;

import engine.gameObject.GameObject;
import engine.gameObject.components.PhysicsBody;
import engine.physics.Velocity;

/**
 * 
 * @author Ben
 *
 */
public class CollisionComposition {
	private static final double FRAMES_PER_SECOND = 60.0;

	public boolean isOnXAxis(GameObject one, GameObject two) {
		GameObject fixed = (one.getPhysicsBody().getScalar("CollisionConstant")
				.getValue() == 1.0) ? one : two;
		GameObject other = (one.getPhysicsBody().getScalar("CollisionConstant")
				.getValue() == 1.0) ? two : one;
		double xVel = other.getPhysicsBody().getVelocity().getX();
		double yVel = other.getPhysicsBody().getVelocity().getY();
		double curX;
		double curY;
		GameObject test = new GameObject(other);
		boolean x;
		boolean y;
		double xPoint;
		double yPoint;
		for (double i = 2.0; i < 150; i++) {
			xPoint = other.getTranslateX();
			yPoint = other.getTranslateY();
			x = false;
			y = false;
			curX = xVel / (i - .9);
			curY = yVel / (i - .9);
			other.setTranslateX(xPoint - curX);
			if (other.getRenderedNode().getBoundsInParent()
					.intersects(fixed.getRenderedNode().getBoundsInParent())) {
				x = true;
			}
			other.setTranslateX(other.getTranslateX() + curX);
			other.setTranslateY(yPoint - curY);
			if (other.getRenderedNode().getBoundsInParent()
					.intersects(fixed.getRenderedNode().getBoundsInParent())) {
				y = true;
			}
			other.setTranslateY(other.getTranslateY() + curY);
			if (x && y) {
				// means we passed the point where one was true, one false, in
				// this case it's too small to notice the difference
				return false;
			}
			if (x && !y) {
				return false;
			}
			if (y && !x) {
				return true;
			}

		}
		return false;
	}

	public void fixedCollision(GameObject one, GameObject two) {
		// System.out.println(xChange / (Math.abs(curX)+Math.abs(otherX)));
		// create new condition to stop x or y
		boolean xAxis = isOnXAxis(one, two);
		GameObject fixed = (one.getPhysicsBody().getScalar("CollisionConstant")
				.getValue() == 1) ? one : two;
		GameObject other = (one.getPhysicsBody().getScalar("CollisionConstant")
				.getValue() == 1) ? two : one;
		//System.out.println(fixed.getPhysicsBody().getCollisionBodyWidth());
		double toMove = 0;
		if (xAxis) {
			other.getPhysicsBody().setVelocity(
					new Velocity(0.0, other.getPhysicsBody().getVelocity()
							.getY()));
			if (other.getTranslateX() < fixed.getTranslateX()) {
				toMove = collisionHelper(fixed.getTranslateX(),
						other.getTranslateX(), fixed.getPhysicsBody()
								.getCollisionBodyHeight() / 2.0,
						other.getPhysicsBody().getCollisionBodyHeight() / 2.0);
			} else {
				toMove = -1.0
						* collisionHelper(fixed.getTranslateX(),
								other.getTranslateX(), fixed.getPhysicsBody()
										.getCollisionBodyHeight() / 2.0, other
										.getPhysicsBody()
										.getCollisionBodyHeight() / 2.0);
			}
		} else {
			if (other.getTranslateY() < fixed.getTranslateY()) {
				toMove = collisionHelper(fixed.getTranslateY(),
						other.getTranslateY(), fixed.getPhysicsBody()
								.getCollisionBodyWidth() / 2.0, other
								.getPhysicsBody().getCollisionBodyWidth() / 2.0);

			} else {
				toMove = -1.0
						* collisionHelper(fixed.getTranslateY(),
								other.getTranslateY(), fixed.getPhysicsBody()
										.getCollisionBodyWidth() / 2.0, other
										.getPhysicsBody()
										.getCollisionBodyWidth() / 2.0);
			}
			other.getPhysicsBody().setVelocity(
					new Velocity(other.getPhysicsBody().getVelocity().getX(),
							fixed.getPhysicsBody().getVelocity().getY()));
			other.setTranslateY(other.getTranslateY() - toMove);

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
