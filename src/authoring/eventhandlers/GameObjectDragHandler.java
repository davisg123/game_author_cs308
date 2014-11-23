package authoring.eventhandlers;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.view.gameobjectsview.GameObjectGraphic;
import engine.level.Level;

/**
 * Event handler for dragging graphics on the level view. Fills properties view
 * with status and allows user to drag objects to adjust the level.
 * 
 * @author Wesley Valentine
 *
 */

public class GameObjectDragHandler implements GameHandler<MouseEvent>{
	private Level myLevel;

	public GameObjectDragHandler(Level level) {
		myLevel = level;
	}

	@Override
	public void handle(MouseEvent event) {
		GameObjectGraphic g = (GameObjectGraphic) event.getSource();
		double x = event.getSceneX();
		double y = event.getSceneY();
		//myLevel.moveSpriteOnLevel(g, x, y);
		
	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_DRAGGED;
	}

}