package engine.collision.objects;

import engine.gameObject.GameObject;

public class FixedObjectCollisionObject extends CollisionObject{

	@Override
	protected void handlePowerupCollisionObject(GameObject thisOne,
			GameObject other) {
		myCollision.fixedCollision(thisOne, other);
		
	}

	@Override
	protected void handleEnemyCollisionObject(GameObject thisOne,
			GameObject other) {
		myCollision.fixedCollision(thisOne, other);		
	}

	@Override
	protected void handleFixedObjectCollisionObject(GameObject thisOne,
			GameObject other) {
		myCollision.fixedCollision(thisOne, other);		
	}

	@Override
	protected void handleHeroCollisionObject(GameObject thisOne,
			GameObject other) {
		myCollision.fixedCollision(thisOne, other);		
	}

	@Override
	public void handleCollision(GameObject thisOne, GameObject other) {
		// TODO other.handleFixedObjectCollisionObject(other, thisOne);
		
	}

}
