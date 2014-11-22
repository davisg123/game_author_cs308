package engine.level;

import java.util.Iterator;

import authoring.model.collections.ConditionsCollection;
import authoring.model.collections.GameObjectsCollection;
import engine.conditions.Condition;
import engine.gameObject.GameObject;

/**
 * A Level of the game. Contains all GameObjects and Actions and coordinates
 * their interactions for linear progression through the game.
 * 
 * @author Will Chang
 * @author Abhishek Balakrishnan
 */

public class Level {

	private GameObjectsCollection myGameObjects;
//	private ConditionsCollection myConditions;

	/**
	 * Constructor
	 * @param Game Objects Collection
	 */
	public Level(GameObjectsCollection gameObjects) {
		myGameObjects = gameObjects;
	}
	
	/**
	 * Updates all GameObjects.
	 */
	public void update() {
		for (GameObject sprite : myGameObjects) {
			sprite.update();
		}
	}

	/**
	 * SET INITIAL VALUES FOR THE MAIN CHARACTER
	 */
	public void updateMainCharacter() {
		
	}
	
	/**
	 * Enables and initializes the Game Objects specified in this Level
	 * 
	 * @param sprites
	 */
	/*
	 * public void setEnabledGameObjects(List<GameObject> sprites) {
	 * for(GameObject sprite : sprites) {
	 * if(myEnabledGameObjects.get(sprite.getID())) { //sprite.enable(); ??
	 * //copy of??? //Initialize the sprite to location???
	 * myGameObjects.add(sprite); } } } /* public void setEnabled(String type,
	 * List<IEnabled> enabledObjects) {
	 * 
	 * for(IEnabled enabledObject : enabledObjects) {
	 * if(myEnabledGameObjects.get(sprite.getID()) } }
	 */

	/**
	 * Enables the Conditions specified in this Level
	 * 
	 * @param conditions
	 */
	/*
	 * public void setEnabledConditions(List<Condition> conditions) {
	 * for(Condition condition : conditions) {
	 * //if(myEnabledConditions.get(condition.getID()) { //TODO have Conditions
	 * Implement IEnabled // condition.enable(); //} } }
	 */
	/*
	public void setEnabledConditions(List<Condition> conditions) {
		 for(Condition condition : conditions) {
		 if(myEnabledConditions.get(condition.getID()) { //TODO have Conditions
		 //Implement IEnabled 
		 condition.enable(); } } }
*/
	/**
	 * Iterator for the List of enabled Game Objects in the Level
	 * 
	 * @return
	 */
	public Iterator<GameObject> getGameObjects() {
		return myGameObjects.iterator();
	}
/*
	public Iterator<Condition> getConditions() {
		return myConditions.iterator();
	} */
}
