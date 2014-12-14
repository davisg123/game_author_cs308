package engine.collision.objects;

import engine.gameObject.GameObject;
import engine.gameObject.components.PhysicsBody;
import engine.physics.CollisionConstant;
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
		boolean x;
		boolean y;
		double xPoint;
		double yPoint;
		for (double i = 3.0; i < 150; i++) {
			xPoint = other.getTranslateX();
			yPoint = other.getTranslateY();
			x = false;
			y = false;
			curX = xVel / (i / 2.0-.4);
			curY = yVel / (i / 2.0-.4);
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
		// instantiating for its toString() method
		CollisionConstant a = new CollisionConstant(0.0);
		GameObject fixed = (one.getPhysicsBody().getScalar(a.toString())
				.getValue() == 1) ? one : two;
		GameObject other = (one.getPhysicsBody().getScalar(a.toString())
				.getValue() == 1) ? two : one;
		if (xAxis) {
			other.getPhysicsBody().setVelocity(
					new Velocity(0.0, other.getPhysicsBody().getVelocity()
							.getY()));
			if (other.getTranslateX() < fixed.getTranslateX()) {
				other.setTranslateX(fixed.getTranslateX()
						- other.getPhysicsBody().getCollisionBodyWidth());
			} else {
				other.setTranslateX(fixed.getTranslateX()
						+ fixed.getPhysicsBody().getCollisionBodyWidth());
			}
		} else {
			other.getPhysicsBody().setVelocity(
					new Velocity(other.getPhysicsBody().getVelocity().getX(),
							fixed.getPhysicsBody().getVelocity().getY()));
			if (other.getTranslateY() < fixed.getTranslateY()) {
				other.setTranslateY(fixed.getTranslateY()
						- other.getPhysicsBody().getCollisionBodyHeight());
			} else {
				other.setTranslateY(fixed.getTranslateY()
						+ fixed.getPhysicsBody().getCollisionBodyHeight());
			}

			// System.out.println(fixed.getTranslateY());
			// System.out.println(other.getRenderedNode().get);

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
