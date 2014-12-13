package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import authoring.model.GameData;
import authoring.model.collections.GeneralCollection;

import com.google.gson.GsonBuilder;

import engine.actions.Action;
import engine.conditions.Condition;
import engine.physics.Force;
import engine.physics.Scalar;

public class DataManager {
	
	public static final String PROGRESS_FOLDER_NAME = "progress";
	private GsonBuilder gson;
	
	public DataManager() {
		gson = new GsonBuilder();
		gson.registerTypeAdapter(Condition.class, new GenericTypeAdapter<Condition>("engine.conditions"));
		gson.registerTypeAdapter(Action.class, new GenericTypeAdapter<Action>("engine.actions", "engine.actions.translate"));
		gson.registerTypeAdapter(GeneralCollection.class, new GenericTypeAdapter<GeneralCollection>("authoring.model.collections"));
		gson.registerTypeAdapter(Force.class, new GenericTypeAdapter<Force>("engine.physics"));
		gson.registerTypeAdapter(Scalar.class, new GenericTypeAdapter<Scalar>("engine.physics"));
	}
	
	/**
	 * Creates a Json file based on an object representing a game.
	 * @param obj Object representing game.
	 * @param file Name Name of Json file.
	 * @return Returns true if successfully writes file.
	 * @throws IOException 
	 */
	public boolean writeGameFile(GameData data, File dataPath) throws IOException {
		String fileName = dataPath.getName() + ".json";
		//File f = new File(dataPath, fileName);
		return writeFile(data, dataPath, fileName);
	}
	
	/**
	 * Gets an object representing a game from a Json file.
	 * @param fileName Name of Json file.
	 * @return Object representing game.
	 */
	public GameData readGameFile(File dataPath) {
		String fileName = dataPath.getName() + ".json";
		return (GameData)readFile(GameData.class, dataPath, fileName);
	}
	
	public boolean writeProgressFile(GameData data, File dataPath, String progressName) 
			throws IOException {
		String fileName = PROGRESS_FOLDER_NAME + "/" + progressName + ".json";
		return writeFile(data, dataPath, fileName);
	}
	
	public GameData readProgressFile(File dataPath, String progressName) {
		String fileName = PROGRESS_FOLDER_NAME + "/" + progressName + ".json";
		return (GameData)readFile(GameData.class, dataPath, fileName);
	}
	
	//check to make sure only writing to json file
	//turn true/false into errors?
	private boolean writeFile(Object obj, File dataPath, String fileName) throws IOException {
			String json = gson.create().toJson(obj);
			File f = new File(dataPath, fileName);
			System.out.println(dataPath + fileName);
			FileWriter writer = new FileWriter(f);
			writer.write(json);
			writer.close();
			return true;
	}
	
	private Object readFile(Class cl, File dataPath, String fileName) {
	    File f = new File(dataPath, fileName);
	    System.out.println(f.toString());
			try {
				BufferedReader br = new BufferedReader( new FileReader(f) );
				Object obj = gson.create().fromJson(br, cl);
				return obj;
			} catch (FileNotFoundException e) {
				return null;
			}
	}
	
	//possibly just force user to add ".json"
	private boolean hasValidName(String fileName) {
		if(!fileName.contains(".")) return true;
		else {
			if(fileName.endsWith(".json")) return true;
			else return false;
		}
	}
	
	private String checkForExtension(String fileName) {
		if(fileName.endsWith(".json")) return fileName;
		else return fileName + ".json";
	}
}
