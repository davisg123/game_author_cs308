package engine.collision.objects;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;

import engine.gameObject.GameObject;

public abstract class CollisionObject {
	protected CollisionComposition myCollision;

	protected abstract void handlePowerupCollisionObject(GameObject thisOne, GameObject other);

	protected abstract void handleEnemyCollisionObject(GameObject thisOne, GameObject other);

	protected abstract void handleFixedObjectCollisionObject(GameObject thisOne,
			GameObject other);

	protected abstract void handleHeroCollisionObject(GameObject thisOne,
			GameObject other);

	// should use reflection in the future to reduce repeated code and won't be
	// abstract will just be in the super
	public abstract void handleCollision(GameObject thisOne, GameObject other);

	public String toString() {
		return new LinkedList<String>(Arrays.asList(this.getClass().toString()
				.split("\\."))).getLast();
	}
}
