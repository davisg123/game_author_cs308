package data;

import gamePlayer.model.DataWrapper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

public class DataManager {
	
	private Gson gson = new Gson();
	private static final String gameDatapath = "/data/games/";
	private static final String progressDatapath = "/data/progress/";
	
	/**
	 * Creates a Json file based on an object representing a game.
	 * @param obj Object representing game.
	 * @param file Name Name of Json file.
	 * @return Returns true if successfully writes file.
	 */
	public boolean writeGameFile(DataWrapper wrapper, String fileName) {
		return writeFile(wrapper, gameDatapath, fileName);
	}
	
	/**
	 * Gets an object representing a game from a Json file.
	 * @param fileName Name of Json file.
	 * @return Object representing game.
	 */
	public DataWrapper readGameFile(String fileName) {
		return (DataWrapper)readFile(DataWrapper.class, gameDatapath, fileName);
	}
	
	/**
	 * Creates a Json file based on an object representing a progress state.
	 * @param obj Object representing progres state.
	 * @param fileName Name of Json file.
	 * @return Returns true if successfully writes file.
	 */
	public boolean writeProgressFile(ProgressObject obj, String fileName) {
		return writeFile(obj, progressDatapath, fileName);
	}
	
	/**
	 * Gets an object representing a progress state from a Json file.
	 * @param fileName Name of Json file.
	 * @return Object representing progress state.
	 */
	public ProgressObject readProgressFile(String fileName) {
		return (ProgressObject)readFile(ProgressObject.class, progressDatapath, fileName);
	}
	
	
	//check to make sure only writing to json file
	//turn true/false into errors?
	private boolean writeFile(Object obj, String datapath, String fileName) {
		//if fileName ends in .json or nothing: otherwise, don't write file
		if(hasValidName(fileName)) {
			fileName = checkForExtension(fileName);
			String json = gson.toJson(obj);
			try {
				FileWriter writer = new FileWriter(datapath + fileName);
				writer.write(json);
				writer.close();
				return true;
			} catch (IOException e) {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	//check 
	private Object readFile(Class cl, String datapath, String fileName) {
		if(hasValidName(fileName)) {
			fileName = checkForExtension(fileName);
			try {
				BufferedReader br = new BufferedReader( new FileReader(datapath + fileName) );
				Object obj = gson.fromJson(br, cl);
				return obj;
			} catch (FileNotFoundException e) {
				return null;
			}
		}
		else {
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
