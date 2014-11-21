package authoring.model;

import java.util.Observable;

/**
 * The Model of the MVC, gets changes in information from the controller and
 * directly updates the view. Individual components observed by the view.
 *
 */
public class AuthoringModel {
	private GameData myGame;

	public AuthoringModel() {
		myGame = new GameData();
	}

	public GameData getData(){
		return myGame;
	}
	
	public void modifyModel(Query q){
		//AuthoringController.getModel().getThing(Levels).get(level1).getSprites().get(Sprite1).getComponents.get(health).set(20)
		//AuthoringController.change(object::method)
	}
	
	
	
	public void save() {
		// TODO - Data
	}

	public GameData load() {
		// TODO - Data
		return null;
	}

	public void importData(GameData gd) {
		// TODO - adds data to current authoring environment

	}
	
	public GraphicsCollection getImages(){
		return myGame.getImages();
	}
	public GameObjectCollection getGameObjectCollection(){
		return myGame.getGameObjects();
	}

}
