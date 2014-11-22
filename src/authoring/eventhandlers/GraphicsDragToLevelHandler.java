package authoring.eventhandlers;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.view.levelview.SingleLevelView;
import authoring.view.propertiesview.PropertiesView;
import authoring.view.spritesview.GameObjectGraphic;

/**
 * Handles user click on graphic objects. Projects graphic properties in
 * PropertiesView and/or creates copy of selected graphic on the active level.
 * 
 * @author Wesley Valentine
 * @author Chris Bernt
 *
 */
public class GraphicsDragToLevelHandler implements GameHandler<MouseEvent> {
	private PropertiesView myProperties;
	private SingleLevelView myLevel;

	public GraphicsDragToLevelHandler(PropertiesView properties, SingleLevelView levelsView) {
		myProperties = properties;
		myLevel = levelsView;
	}

	@Override
	public void handle(MouseEvent event) {
		GameObjectGraphic g = (GameObjectGraphic) event.getSource();
		double x = event.getSceneX();
		double y = event.getSceneY();
		myLevel.addGameObjectToView(g.getGameObject(), x, y, new GraphicsDragHandler(
				myLevel), new GameObjectClickHandler(myProperties));

	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_RELEASED;
	}

}