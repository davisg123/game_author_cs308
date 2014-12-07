package authoring.eventhandlers;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import authoring.model.collections.GameObjectsCollection;
import authoring.model.collections.LevelsCollection;
import authoring.view.levelview.LevelsView;
import authoring.view.levelview.SingleLevelView;
import authoring.view.wizardview.LevelWizard;
import authoring.view.wizardview.Wizard;
import engine.level.Level;


public class AddLevelHandler implements GameHandler<Event> {
	
	private LevelsView myLevels;
	private LevelsCollection myLevelsCollection;
	private String myLevelID;
	private Wizard myWizard;

	/**
	 * 
	 * @param levelsCollection
	 * @param levelView		WE CAN REMOVE THIS AND PUT IT IN THE UPDATE
	 */
	public AddLevelHandler (LevelsCollection levelsCollection, LevelsView levelView){
		myLevelsCollection = levelsCollection;
		myLevels = levelView;
	}
	
	@Override
	public void handle(Event arg0) {
		promptLevelID();
	}
	
	private void createLevel(){
		SingleLevelView newLevelView = myLevels.addNewLevel(myLevelID);
		Level levelData = new Level(new GameObjectsCollection());
		levelData.addObserver(newLevelView);
		newLevelView.setID(myLevelID);
		levelData.setLevelID(myLevelID);
		myLevelsCollection.add(levelData);
		//System.out.println(levelData);		
	}

	@Override
	public EventType<Event> getEventType() {
		return Event.ANY;
	}
	
	private void promptLevelID(){
		myWizard = new LevelWizard("New Level", 200, 200, event -> getPrompt());
	}
	
	private void getPrompt(){
		myLevelID = myWizard.getMap().get("name").getInformation();
		createLevel();
		myWizard.close();
	}
	
}
