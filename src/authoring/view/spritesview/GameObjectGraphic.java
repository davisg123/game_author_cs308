package authoring.view.spritesview;

import authoring.eventhandlers.GameHandler;
import authoring.view.graphicsview.Graphic;
import engine.gameObject.GameObject;

public class GameObjectGraphic extends Graphic{

	private GameObject myGameObject;
	
	public GameObjectGraphic(GameObject gameObject, GameHandler ...event) {
		super(gameObject.getCurrentImageName(), event);
		myGameObject = gameObject;
	}
	
	public GameObject getGameObject(){
		return myGameObject;
	}

}
