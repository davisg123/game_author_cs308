package data;

import engine.actions.Action;
import engine.actions.ChangeLevelAction;
import engine.actions.TestAction;
import engine.actions.translate.TestTranslateAction;
import engine.conditions.CollisionCondition;
import engine.conditions.Condition;
import engine.gameObject.GameObject;
import engine.gameObject.components.Component;
import engine.level.Level;
import engine.physics.Force;
import engine.physics.Scalar;
import gamePlayer.model.DataWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import authoring.model.GameData;
import authoring.model.collections.GameObjectCollection;
import authoring.model.collections.GeneralCollection;
import authoring.model.GameData;
import authoring.model.collections.GameObjectCollection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DataManager {
	
	private GsonBuilder gson;
	private static final String gameDatapath = "src/data/games/";
//	private static final String progressDatapath = "src/data/progress/";
//	private static final String sampleDatapath = "src/data/sample/";
	private String myGameFileName = "gameData.json";
	
	public DataManager() {
		gson = new GsonBuilder();
		//gson.registerTypeAdapter(Condition.class, new ConditionTypeAdapter());
		//Class[] classes = {Condition.class, Action.class};
		//String[] packages = {"engine.conditions", "engine.actions"};
		//for(int i = 0; i < classes.length; i++) {
			//gson.registerTypeAdapter(classes[i], new GenericTypeAdapter<classes[i]>(packages[i]));
			gson.registerTypeAdapter(Condition.class, new GenericTypeAdapter<Condition>("engine.conditions"));
			gson.registerTypeAdapter(Action.class, new GenericTypeAdapter<Action>("engine.actions", "engine.actions.translate"));
			gson.registerTypeAdapter(GeneralCollection.class, new GenericTypeAdapter<GeneralCollection>("authoring.model.collections"));
			gson.registerTypeAdapter(Force.class, new GenericTypeAdapter<Force>("engine.physics"));
			gson.registerTypeAdapter(Scalar.class, new GenericTypeAdapter<Scalar>("engine.physics"));
		//}
	}
	
	/**
	 * Testing DataManager
	 * @param args
	 * @throws IOException 
	 */
//	public static void main(String[]args) throws IOException {
//		DataManager manager = new DataManager();
//		
////		SampleWrapper writeSW = new SampleWrapper();
////		System.out.println(writeSW);
////		boolean success = manager.writeSampleFile(writeSW, "sampleThree.json");
////		System.out.println("wrapper written: " + success);
////		SampleWrapper readSW = manager.readSampleFile("sampleThree.json");
////		System.out.println(readSW);
//		
//		GameData writeData = new GameData();
//		
//		//adding levels to GameData
//		String im = "/assets/mario.png";
//		GameObject mario = new GameObject(new ArrayList<Component>(), im, 0, 0,
//				0, 0, 0, "Mario");
//		GameObjectsCollection goc = new GameObjectsCollection();
//		//goc.addGameObject(mario);
//		//Level level = new Level(goc);
//		//writeData.addLevel(level);
//		
//		List<Action> actionList = new ArrayList<Action>();
//		Action ac1 = new TestAction("action1");
//		Action ac2 = new TestTranslateAction("action2");
//		actionList.add(ac1);
//		actionList.add(ac2);
//		List<GameObject> gameObjectList = new ArrayList<GameObject>();
//		Condition cond = new CollisionCondition(actionList, gameObjectList, "condition1");
//		writeData.addCondition(cond);
//		
//		
//		String nameOfFile = "gameDataFour.json";
//		System.out.println(writeData);
//		boolean success = manager.writeGameFile(writeData, nameOfFile);
//		System.out.println("data written: " + success);
//		GameData readData = manager.readGameFile(nameOfFile);
//		System.out.println(readData);
//	}
	
//	public boolean writeSampleFile(SampleWrapper sw, String fileName) throws IOException {
//		return writeFile(sw, sampleDatapath, fileName);
//	}
//	
//	public SampleWrapper readSampleFile(String fileName) {
//		return (SampleWrapper)readFile(SampleWrapper.class, sampleDatapath, fileName);
//	}
	
	/**
	 * Creates a Json file based on an object representing a game.
	 * @param obj Object representing game.
	 * @param file Name Name of Json file.
	 * @return Returns true if successfully writes file.
	 * @throws IOException 
	 */
	public boolean writeGameFile(GameData data, String nameOfFile) throws IOException {
		return writeFile(data, gameDatapath, nameOfFile);
	}
//	public boolean writeGameFile(GameData data, String fileName) throws IOException {
//		return writeFile(data, gameDatapath, fileName);
//	}
	
	/**
	 * Gets an object representing a game from a Json file.
	 * @param fileName Name of Json file.
	 * @return Object representing game.
	 */
	public GameData readGameFile(String fileName) {
		return (GameData)readFile(GameData.class, gameDatapath, fileName);
	}
	
//	/**
//	 * Creates a Json file based on an object representing a progress state.
//	 * @param obj Object representing progres state.
//	 * @param fileName Name of Json file.
//	 * @return Returns true if successfully writes file.
//	 */
//	public boolean writeProgressFile(ProgressObject obj, String fileName) {
//		return writeFile(obj, progressDatapath, fileName);
//	}
//	
//	/**
//	 * Gets an object representing a progress state from a Json file.
//	 * @param fileName Name of Json file.
//	 * @return Object representing progress state.
//	 */
//	public ProgressObject readProgressFile(String fileName) {
//		return (ProgressObject)readFile(ProgressObject.class, progressDatapath, fileName);
//	}
	
	
	//check to make sure only writing to json file
	//turn true/false into errors?
	private boolean writeFile(Object obj, String datapath, String fileName) throws IOException {
		//if fileName ends in .json or nothing: otherwise, don't write file
		if(hasValidName(fileName)) {
			fileName = checkForExtension(fileName);
			String json = gson.create().toJson(obj);
//			try {
				//File f = new File("myFileThough.json");
				File f = new File(datapath + fileName);
				System.out.println(datapath + fileName);
				//FileWriter writer = new FileWriter(datapath + fileName);
				FileWriter writer = new FileWriter(f);
				writer.write(json);
				writer.close();
				return true;
//			} catch (IOException e) {
//				return false;
//			}
		}
		else {
			return false;
		}
	}
//	private boolean writeFile(Object obj, String datapath, String fileName) throws IOException {
//		//if fileName ends in .json or nothing: otherwise, don't write file
//		if(hasValidName(fileName)) {
//			fileName = checkForExtension(fileName);
//			String json = gson.create().toJson(obj);
////			try {
//				//File f = new File("myFileThough.json");
//				File f = new File(datapath + fileName);
//				System.out.println(datapath + fileName);
//				//FileWriter writer = new FileWriter(datapath + fileName);
//				FileWriter writer = new FileWriter(f);
//				writer.write(json);
//				writer.close();
//				return true;
////			} catch (IOException e) {
////				return false;
////			}
//		}
//		else {
//			return false;
//		}
//	}
	
	//check 
	private Object readFile(Class cl, String datapath, String fileName) {
		if(hasValidName(fileName)) {
			fileName = checkForExtension(fileName);
			try {
				BufferedReader br = new BufferedReader( new FileReader(datapath + fileName) );
				Object obj = gson.create().fromJson(br, cl);
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
