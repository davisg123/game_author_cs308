package authoring.eventhandlers;

import javafx.event.EventType;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import authoring.model.collections.LevelsCollection;
import authoring.view.gameobjectsview.GameObjectGraphic;
import authoring.view.levelview.LevelsView;
import authoring.view.propertiesview.PropertiesView;
import engine.gameObject.GameObject;
import engine.level.Level;

/**
 * Handles user click on graphic objects. Projects graphic properties in
 * PropertiesView and/or creates copy of selected graphic on the active level.
 * 
 * @author Wesley Valentine
 * @author Chris Bernt
 * 
 *
 */
public class GameObjectDragToLevelHandler implements GameHandler<MouseEvent> {
	private LevelsView myLevelView;
	private LevelsCollection myLevelsCollection;

	public GameObjectDragToLevelHandler(LevelsView levelView,
			LevelsCollection data) {
		myLevelView = levelView;
		myLevelsCollection = data;
	}

	@Override
	public void handle(MouseEvent event) {
		GameObjectGraphic g = (GameObjectGraphic) event.getSource();
		double x = event.getSceneX();
		double y = event.getSceneY();
		GameObject gameObject = g.getGameObject();
		GameObject newGameObject = new GameObject(gameObject);
		newGameObject.setX(x);
		newGameObject.setY(y);
		String id = myLevelView.getCurrentLevel().getID();
		for (Level level : myLevelsCollection) {
			if (level.getLevelID().equals(id) && myLevelView.contains(x-230, y-100)) {
				level.addGameObject(newGameObject);
			}
		}

	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_RELEASED;
	}

}