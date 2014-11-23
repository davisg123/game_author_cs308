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
	private PropertiesView myProperties;
	private Level myLevel;

	public GameObjectDragToLevelHandler(PropertiesView properties, Level level) {
		myProperties = properties;
		myLevel = level;
	}

	@Override
	public void handle(MouseEvent event) {
		GameObjectGraphic g = (GameObjectGraphic) event.getSource();
		double x = event.getSceneX();
		double y = event.getSceneY();
		GameObject gO = g.getGameObject();
		//gO.setPosition(new Point2D(x,y));
		myLevel.addGameObject(g.getGameObject());
	
	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_RELEASED;
	}

}