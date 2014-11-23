package authoring.eventhandlers;

import javafx.event.EventType;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import authoring.view.gameobjectsview.GameObjectGraphic;
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
 */
public class GameObjectDragToLevelHandler implements GameHandler<MouseEvent> {
	private Level myLevel;

	public GameObjectDragToLevelHandler(Level level) {
		myLevel = level;
	}

	@Override
	public void handle(MouseEvent event) {
		GameObjectGraphic g = (GameObjectGraphic) event.getSource();
		double x = event.getSceneX();
		double y = event.getSceneY();
		GameObject gameObject = g.getGameObject();
		gameObject.setX(x);
		gameObject.setY(y);
		myLevel.addGameObject(gameObject);
	
	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_RELEASED;
	}

}