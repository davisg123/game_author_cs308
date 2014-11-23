package authoring.eventhandlers;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.model.collections.LevelsCollection;
import authoring.view.gameobjectsview.GameObjectGraphic;
import authoring.view.levelview.LevelsView;
import engine.level.Level;

/**
 * Event handler for dragging graphics on the level view. Fills properties view
 * with status and allows user to drag objects to adjust the level.
 * 
 * @author Wesley Valentine
 *
 */

public class GameObjectDragHandler implements GameHandler<MouseEvent> {

	private LevelsView myLevelView;
	private LevelsCollection myLevelsCollection;

	public GameObjectDragHandler(LevelsView levelView, LevelsCollection data) {
		myLevelView = levelView;
		myLevelsCollection = data;
	}

	@Override
	public void handle(MouseEvent event) {
		System.out.println("reached");
		GameObjectGraphic g = (GameObjectGraphic) event.getSource();
		double x = event.getSceneX();
		double y = event.getSceneY();
		String id = myLevelView.getCurrentLevel().getID();
		for (Level level : myLevelsCollection) {
			if (level.getLevelID().equals(id)) {
				level.removeGameObject(g.getGameObject());
				g.getGameObject().setX(x);
				g.getGameObject().setY(y);
				level.addGameObject(g.getGameObject());
			}
		}

	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_RELEASED;
	}

}