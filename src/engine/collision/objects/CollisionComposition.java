package engine.collision.objects;

import engine.gameObject.GameObject;
import engine.gameObject.components.PhysicsBody;
import engine.physics.Velocity;

public class CollisionComposition {
	private static final double FRAMES_PER_SECOND = 60.0;

	public boolean isOnXAxis(GameObject one, GameObject two) {
		return false;
		/*
		GameObject fixed = (one.getPhysicsBody().getScalar("CollisionConstant")
				.getValue() == 1.0) ? one : two;
		GameObject other = (one.getPhysicsBody().getScalar("CollisionConstant")
				.getValue() == 1.0) ? two : one;
		double xFixed = fixed.getTranslateX();
		double yFixed = fixed.getTranslateY();
		double xOther = other.getTranslateX();
		double yOther = other.getTranslateY();
		double fixedHeight = fixed.getPhysicsBody().getCollisionBodyWidth() / 2.0;
		double fixedWidth = fixed.getPhysicsBody().getCollisionBodyHeight() / 2.0;
		double otherHeight = other.getPhysicsBody().getCollisionBodyWidth() / 2.0;
		double otherWidth = other.getPhysicsBody().getCollisionBodyHeight() / 2.0;
		double xChange = 0.0;
		double yChange = 0.0;
		// maybe math.abs
		double xVelocity = Math
				.abs(other.getPhysicsBody().getVelocity().getX());
		double yVelocity = Math
				.abs(other.getPhysicsBody().getVelocity().getY());
		if (xFixed > xOther && yFixed > yOther) {
			System.out.println("1");
			xChange = (xOther + otherWidth) - (xFixed - fixedWidth);
			yChange = (yOther + otherHeight) - (yFixed - fixedHeight);
			return (xChange / xVelocity) < (yChange / yVelocity);
		}
		if (xFixed > xOther && yFixed <= yOther) {
			System.out.println("2");
			xChange = (xOther + otherWidth) - (xFixed - fixedWidth);
			yChange = (yFixed + fixedHeight) - (yOther - otherHeight);
			return (xChange / xVelocity) < (yChange / yVelocity);
		}
		if (xFixed < xOther && yFixed > yOther) {
			System.out.println("3");
			xChange = (xFixed + fixedWidth) - (xOther - otherWidth);
			yChange = (yOther + otherHeight) - (yFixed - fixedHeight);
			return (xChange / xVelocity) < (yChange / yVelocity);
		}
		if (xFixed < xOther && yFixed <= yOther) {
			System.out.println("4");
			xChange = (xFixed + fixedWidth) - (xOther - otherWidth);
			yChange = (yFixed + fixedHeight) - (yOther - otherHeight);
			return (xChange / xVelocity) < (yChange / yVelocity);

		}

*/
	}

	public void fixedCollision(GameObject one, GameObject two) {

		// System.out.println(xChange / (Math.abs(curX)+Math.abs(otherX)));
		// create new condition to stop x or y
		boolean xAxis = isOnXAxis(one, two);
		GameObject fixed = (one.getPhysicsBody().getScalar("CollisionConstant")
				.getValue() == 1) ? one : two;
		GameObject other = (one.getPhysicsBody().getScalar("CollisionConstant")
				.getValue() == 1) ? two : one;
		double toMove = 0;
		if (xAxis) {
			other.getPhysicsBody().setVelocity(
					new Velocity(0.0, other.getPhysicsBody().getVelocity()
							.getY()));
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
					new Velocity(fixed.getPhysicsBody().getVelocity().getX(),
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
