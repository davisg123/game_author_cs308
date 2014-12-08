package authoring.eventhandlers;

import javafx.event.Event;
import javafx.event.EventType;
import authoring.model.collections.GameObjectsCollection;
import authoring.model.collections.LevelsCollection;
import authoring.view.levelview.LevelsView;
import authoring.view.levelview.SingleLevelView;
import engine.gameObject.Identifier;
import authoring.view.wizards.LevelWizard;
import authoring.view.wizards.Wizard;
import engine.level.Level;


public class AddLevelHandler implements GameHandler<Event> {
	
	private LevelsView myLevels;
	private LevelsCollection myLevelsCollection;
	private String myLevelID;
	private boolean isFirstLevel;
	private LevelWizard myWizard;

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
		Level levelData = new Level(new GameObjectsCollection(), isFirstLevel);
		levelData.addObserver(newLevelView);
		newLevelView.setID(myLevelID);
		levelData.setIdentifier(new Identifier("Level", myLevelID));
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
		isFirstLevel = myWizard.getIsFirst();
		createLevel();
		myWizard.close();
	}
	
}
