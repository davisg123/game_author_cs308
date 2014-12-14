package authoring.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import authoring.model.collections.ConditionsCollection;
import authoring.model.collections.GameObjectsCollection;
import authoring.model.collections.ImagesCollection;
import authoring.model.collections.LevelsCollection;
import authoring.model.collections.SoundsCollection;
import data.DataManager;
import engine.conditions.Condition;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.level.Level;
import errorsAndExceptions.ErrorPopUp;

/**
 * The Model of the MVC, gets changes in information from the controller and
 * directly updates the view. Individual components observed by the view.
 * @author Arjun Jain
 */
public class AuthoringModel {
	private GameData myGame;
	private DataManager myDataManager;

	public AuthoringModel() {
		myGame = new GameData();
		myDataManager = new DataManager();
	}

	public GameData getData(){
		return myGame;
	}
	
	/**
	 * Save the current GameData using serialization
	 */
	public void save(File dataPath) {
		// TODO - Data
		GameData mySerializableGame = convertToSerializable();
		try {
			boolean success = myDataManager.writeGameFile(mySerializableGame, dataPath);
			System.out.println("game saved = " + success);
			myDataManager.writeProgressFile(mySerializableGame, dataPath, "initial");
		} catch (IOException e) {
			ErrorPopUp epu = new ErrorPopUp(e);
			epu.display("Won't save", false);
		}
	}
	
	private GameData convertToSerializable(){
		GameData mySerializableGame = new GameData();
		List<GameObject> allGameObjects = new ArrayList<GameObject>();
		for(String s : myGame.getImages()){
			mySerializableGame.getImages().add(s);
		}
		for(GameObject g: myGame.getGameObjects()){
			allGameObjects.add(g);
		}
		for(Level l: myGame.getLevels()){
			List<Identifier> levelGameObjectsIDs = new ArrayList<Identifier>();
			for(GameObject g : l.getGameObjectsCollection()){
				/**
				Identifier i = new Identifier(g.getID(),Integer.toString(IDcounter));
				g.setIdentifier(i);
				IDcounter++;
				**/
				allGameObjects.add(g);
				levelGameObjectsIDs.add(g.getIdentifier());
			}
			Level levelToAdd = new Level(levelGameObjectsIDs);
			levelToAdd.setStartIndicator(l.isStartLevel());
			levelToAdd.setIdentifier(new Identifier(l.getIdentifier().getType(),l.getIdentifier().getUniqueId()));
			levelToAdd.setConditionIds(l.getConditionIdentifiers());
			levelToAdd.setBackgroundImage(l.getBackgroundImage());
			levelToAdd.setBackgroundMusic(l.getBackgroundMusic());
			mySerializableGame.getLevels().add(levelToAdd);
		}
		for(Condition c : myGame.getConditions()){
			mySerializableGame.getConditions().add(c);
		}
		for(GameObject g: allGameObjects){
			mySerializableGame.getGameObjects().add(g);
		}
		for(String s: myGame.getSounds()){
			mySerializableGame.getSounds().add(s);;
		}
		return mySerializableGame;
	}
	
	private void convertFromSerializable(GameData input){
		for(String s : input.getImages()){
			myGame.getImages().add(s);
		}
		for (Level l: input.getLevels()){
			GameObjectsCollection newObjects = new GameObjectsCollection();
			for(Identifier i: l.getGameObjectIDs()){
				for(GameObject g : input.getGameObjects()){
					if(i.getUniqueId().equals(g.getIdentifier().getUniqueId())){
						newObjects.add(g);
					}
				}
				for(GameObject g : newObjects){
					input.getGameObjects().remove(g);
				}
			}
			//l.getGameObjectIDs().clear();
			Level newLevel = new Level(newObjects);
			newLevel.setStartIndicator(l.isStartLevel());
			newLevel.setIdentifier(l.getIdentifier());
			newLevel.setConditionIds(l.getConditionIdentifiers());
			newLevel.setBackgroundImage(l.getBackgroundImage());
			newLevel.setBackgroundMusic(l.getBackgroundMusic());
			myGame.getLevels().add(newLevel);
		}
		for(Condition c: input.getConditions()){
			myGame.getConditions().add(c);
		}
		for(GameObject g : input.getGameObjects()){
			myGame.getGameObjects().add(g);
		}
		for(String s: input.getSounds()){
			myGame.getSounds().add(s);
		}
	}

	/**
	 * Replaces the current GameData file with a new file that is loaded in
	 */
	public void load(GameData input) {
		convertFromSerializable(input);
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
