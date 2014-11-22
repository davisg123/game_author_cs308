package authoring.eventhandlers;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.view.graphicsview.Graphic;
import authoring.view.levelview.SingleLevelView;

/**
 * Event handler for dragging graphics on the level view. Fills properties view
 * with status and allows user to drag objects to adjust the level.
 * 
 * @author Wesley Valentine
 *
 */

public class GraphicsDragHandler implements GameHandler<MouseEvent>{
	private SingleLevelView myLevel;

	public GraphicsDragHandler(SingleLevelView levels) {
		myLevel = levels;
	}

	@Override
	public void handle(MouseEvent event) {
		Graphic g = (Graphic) event.getSource();
		double x = event.getSceneX();
		double y = event.getSceneY();
		myLevel.moveSpriteOnLevel(g, x, y);
	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_DRAGGED;
	}

}