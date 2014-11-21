package engine.states;

import javafx.scene.image.Image;
import engine.conditions.Condition;
import engine.gameObject.GameObject;

public abstract class State {
	
	private GameObject sprite;
	private String imageName;
	
	public State() {
		
	}
	
	//DESIGN QUESTION: sprite can either be instance variable or parameter
	//DESIGN QUESTION: image can be held by state as constant or by sprite as constant
	
	/**
	 * Enter this state by changing sprite's image and doing anything else that happens
	 * when sprite initially enters the state.
	 * @param sprite Sprite that is entering this state.
	 */
	//probably make this abstract, but code helpful for understanding
	public void enter(GameObject sprite) {
		sprite.setCurrentImagePath(imageName);
	}
	
	public abstract State handleCondition(Condition condition, GameObject sprite);
	
	//e.g., chargeTime++
	public abstract void update(GameObject sprite);
	
	/**
	 * Do whatever is done when sprite exits its current state.
	 * @param sprite Sprite that is exiting this state.
	 */
	public abstract void exit(GameObject sprite);
}
