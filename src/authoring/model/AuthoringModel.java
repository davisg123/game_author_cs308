package authoring.model;

import java.io.IOException;

import data.DataManager;
import authoring.model.collections.ConditionsCollection;
import authoring.model.collections.GameObjectsCollection;
import authoring.model.collections.ImagesCollection;
import authoring.model.collections.LevelsCollection;
import authoring.model.collections.SoundsCollection;

/**
 * The Model of the MVC, gets changes in information from the controller and
 * directly updates the view. Individual components observed by the view.
 * @author Arjun Jain
 */
public class AuthoringModel {
	private GameData myGame;

	public AuthoringModel() {
		myGame = new GameData();
	}

	public GameData getData(){
		return myGame;
	}
	
	/**
	 * Save the current GameData using serialization
	 */
	public void save() {
		// TODO - Data
		DataManager manager = new DataManager();
		try {
			boolean success = manager.writeGameFile(myGame, "SavedGame1.json");
			System.out.println("game saved = ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Replaces the current GameData file with a new file that is loaded in
	 */
	public void load() {
		// TODO - Data
	}

	/**
	 * Allows the user to extract certain elements from a GameData object to import into their current project
	 * @param gd Represents the GameData object from which we want to extract elements
	 */
	public void importData(GameData gd) {
		// TODO - adds data to current authoring environment

	}
	
	public ImagesCollection getImages(){
		return myGame.getImages();
	}
	
	public GameObjectsCollection getGameObjectCollection(){
		return myGame.getGameObjects();
	}
	
	public LevelsCollection getLevels(){
		return myGame.getLevels();
	}

	public ConditionsCollection getConditions(){
		return myGame.getConditions();
	}

	public SoundsCollection getSounds(){
		return myGame.getSounds();
	}
	
}
