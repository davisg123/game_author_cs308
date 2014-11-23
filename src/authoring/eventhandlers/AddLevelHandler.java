package authoring.eventhandlers;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Scene;
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

	public AddLevelHandler (LevelsCollection levelsCollection){
		myLevelsCollection = levelsCollection;
	}
	
	@Override
	public void handle(Event arg0) {
		SingleLevelView newLevelView = myLevels.getLevelOptions().addNewLevel();
		Level levelData = new Level(new GameObjectsCollection());
		myLevelsCollection.add(levelData);
		levelData.addObserver(newLevelView);
		
//		String im = "/assets/mario.png";
//		GameObject test = new GameObject(new ArrayList<Component>(), im, new Point2D.Double(), 0, 0, 0, "Mario");
//		levelData.addGameObject(test);
	}
	
	public void setLevelOptions(LevelsView l){
		myLevels = l;
	}

	@Override
	public EventType<Event> getEventType() {
		return Event.ANY;
	}
	
	public void promptLevelID(){
		Stage dialog = new Stage();
		dialog.initStyle(StageStyle.UTILITY);
		Group root = new Group();
		Text t = new Text(25, 25, "Level ID:");
		TextField input = new TextField();
		input.setLayoutX(50);
		input.setLayoutY(50);
		root.getChildren().addAll(t, input);
		Scene scene = new Scene(root, 300, 300);
		dialog.setScene(scene);
		dialog.show();
	}
}
