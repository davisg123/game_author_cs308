package authoring.eventhandlers;

import authoring.model.collections.LevelsCollection;
import authoring.view.gameobjectsview.GameObjectGraphic;
import authoring.view.levelview.LevelsView;
import authoring.view.levelview.SingleLevelView;
import authoring.view.propertiesview.PropertiesView;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;

/**
 * Event handler for animation of dragging graphics on the level view.
 * Properties are not updated until drag is releasd.
 * 
 * @author Eli Lichtenberg
 * @author Wesley Valentine
 * 
 */

public class GameObjGraphicDragHandler implements GameHandler<MouseEvent>{
	
	private LevelsView myLevelView;
	
	public GameObjGraphicDragHandler(LevelsView levelView) {
		myLevelView = levelView;
	}

	@Override
	public void handle(MouseEvent event) {
		GameObjectGraphic g = (GameObjectGraphic) event.getSource();
		double mouseX = event.getSceneX();
		double mouseY = event.getSceneY();
		SingleLevelView slv = myLevelView.getCurrentLevel();
		slv.moveGameObjectToLevel(g, mouseX, mouseY);
	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_DRAGGED;
	}

}
