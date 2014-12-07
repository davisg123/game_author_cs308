package authoring.view.icons;

import java.io.File;

import authoring.eventhandlers.GameHandler;
import engine.gameObject.GameObject;

public class GameObjectIcon extends ImageBasedIcon {

	private GameObject myGameObject;

	public GameObjectIcon(GameObject gameObject, File location,
			GameHandler... event) {
		super(gameObject.getCurrentImageName(), location, event);
		myGameObject = gameObject;
	}

	public GameObject getGameObject() {
		return myGameObject;
	}
}
