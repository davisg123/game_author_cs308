package authoring.eventhandlers;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.view.icons.GameObjectIcon;
import authoring.view.levelview.LevelsView;
import authoring.view.levelview.SingleLevelView;

/**
 * Event handler for animation of dragging graphics on the level view.
 * Properties are not updated until drag is released.
 * 
 * @author Eli Lichtenberg
 * @author Wesley Valentine
 * @author Kevin Li
 * @author Chris Bernt
 * @author Arjun Jain
 * @author Safkat Islam
 */

public class GameObjGraphicDragHandler implements GameHandler<MouseEvent> {

	private LevelsView myLevelView;

	public GameObjGraphicDragHandler(LevelsView levelView) {
		myLevelView = levelView;
	}

	@Override
	public void handle(MouseEvent event) {
		SingleLevelView slv = myLevelView.getCurrentLevel();
		GameObjectIcon g = (GameObjectIcon) event.getSource();
		double mouseX = event.getSceneX() + slv.getHvalue()
				* (slv.getPaneWidth() - slv.getViewWidth());
		double mouseY = event.getSceneY() + slv.getVvalue()
				* (slv.getPaneHeight() - slv.getViewHeight());
		//System.out.println(slv.getVvalue());
		//System.out.println(slv.getPaneWidth());

		slv.moveGameObjectToLevel(g, mouseX, mouseY);
	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_DRAGGED;
	}

}
