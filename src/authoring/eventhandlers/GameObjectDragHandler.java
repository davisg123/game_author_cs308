package authoring.eventhandlers;

import static authoring.view.levelview.SingleLevelView.OBJECT_X_OFFSET;
import static authoring.view.levelview.SingleLevelView.OBJECT_Y_OFFSET;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.model.collections.LevelsCollection;
import authoring.view.icons.GameObjectIcon;
import authoring.view.levelview.LevelsView;
import authoring.view.levelview.SingleLevelView;
import authoring.view.propertiesview.PropertiesView;
import engine.gameObject.GameObject;
import engine.level.Level;

/**
 * Event handler for dragging graphics on the level view. Fills properties view
 * with status and allows user to drag objects to adjust the level.
 * 
 * @author Kevin Li
 * @author Arjun Jain
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Safkat Islam
 * @author Eli Lichtenberg
 */

public class GameObjectDragHandler implements GameHandler<MouseEvent> {

	private LevelsView myLevelView;
	private LevelsCollection myLevelsCollection;
	private PropertiesView myProperties;

	public GameObjectDragHandler(LevelsView levelView, LevelsCollection data,
			PropertiesView props) {
		myLevelView = levelView;
		myLevelsCollection = data;
		myProperties = props;
	}

	@Override
	public void handle(MouseEvent event) {
		// System.out.println("reached");
		GameObjectIcon g = (GameObjectIcon) event.getSource();
		double mouseX = event.getSceneX();
		double mouseY = event.getSceneY();
		SingleLevelView slv = myLevelView.getCurrentLevel();
		String id = myLevelView.getCurrentLevel().getID();
		for (Level level : myLevelsCollection) {
			if (level.getIdentifier().getUniqueId().equals(id)) {
				GameObject go = g.getGameObject();
				level.removeGameObject(go);

				double dragX = mouseX + OBJECT_X_OFFSET;
				double dragY = mouseY + OBJECT_Y_OFFSET;
				double newX = mouseX;
				double newY = mouseY;

				if (dragX < 0) {
					System.out.println("off left");
					newX = -1 * OBJECT_X_OFFSET;
				}
				if (dragX > slv.getViewWidth()) {
					System.out.println("off right");
					newX = slv.getViewWidth() - OBJECT_X_OFFSET - g.getWidth();
				}
				if (dragY < 0) {
					System.out.println("off top");
					newY = -1 * OBJECT_Y_OFFSET;
				}
				if (dragY > slv.getViewHeight()) {
					System.out.println("off bottom");
					newY = slv.getViewHeight() - OBJECT_Y_OFFSET
							- g.getHeight();
				}
				go.setX(newX + slv.getHvalue()
						* (slv.getPaneWidth() - slv.getViewWidth()));
				go.setY(newY + slv.getVvalue()
						* (slv.getPaneHeight() - slv.getViewHeight()));

				level.addGameObject(go);
				myProperties.displayProperties(go);
			}
		}

	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_RELEASED;
	}

}