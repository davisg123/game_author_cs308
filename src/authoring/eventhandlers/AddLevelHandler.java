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
import engine.level.Level;


public class AddLevelHandler implements GameHandler<Event> {
	
	private LevelsView myLevels;
	private LevelsCollection myLevelsCollection;
	private String myLevelID;

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
	
		
		
//		String im = "/assets/mario.png";
//		GameObject test = new GameObject(new ArrayList<Component>(), im, new Point2D.Double(), 0, 0, 0, "Mario");
//		levelData.addGameObject(test);
	}
	
	public void createLevel(){
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
		Stage dialog = new Stage();
		dialog.initStyle(StageStyle.DECORATED);
		Group root = new Group();
		Text t = new Text(25, 25, "Level ID:");
		TextField input = new TextField();
		input.setLayoutX(25);
		input.setLayoutY(55);
		Button submit = new Button();
		submit.setLayoutX(25);
		submit.setLayoutY(90);
		submit.setOnAction(event -> getPrompt(input, dialog));
		submit.setText("Submit");
		root.getChildren().addAll(t, input, submit);
		Scene scene = new Scene(root, 300, 150);
		dialog.setScene(scene);
		dialog.show();
	}
	
	private void getPrompt(TextField t, Stage s){
		myLevelID = t.getText();
		createLevel();
		s.close();
	}
	
}
