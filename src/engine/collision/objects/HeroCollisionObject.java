package engine.collision.objects;

import engine.gameObject.GameObject;

/**
 * 
 * @author Ben
 *
 */
public class HeroCollisionObject extends CollisionObject {

	@Override
	protected void handlePowerupCollisionObject(GameObject thisOne,
			GameObject other) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void handleEnemyCollisionObject(GameObject thisOne,
			GameObject other) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void handleFixedObjectCollisionObject(GameObject thisOne,
			GameObject other) {
		myCollision.fixedCollision(other, thisOne);
	}

	@Override
	protected void handleHeroCollisionObject(GameObject thisOne,
			GameObject other) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleCollision(GameObject thisOne, GameObject other) {
		// other.getCollisionObject.handleHeroCollisionObject(other, thisOne);
	}

}
