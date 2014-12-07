package authoring.view.gameobjectsview;

import java.io.File;

import authoring.eventhandlers.GameHandler;
import authoring.view.graphicsview.Graphic;
import engine.gameObject.GameObject;

public class GameObjectGraphic extends Graphic{

	private GameObject myGameObject;
	
	public GameObjectGraphic(GameObject gameObject, File location, GameHandler ...event) {
		super(gameObject.getCurrentImageName(), location, event);
		myGameObject = gameObject;
	}
	
	public GameObject getGameObject(){
		return myGameObject;
	}

	@Override
	public void makeProperties() {
		// TODO Auto-generated method stub
		
	}

}