package authoring.eventhandlers;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.view.graphicsview.Graphic;
import authoring.view.levelview.LevelsView;
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
	private LevelsView myLevels;

	public GraphicsDragToLevelHandler(PropertiesView properties, LevelsView levelsView) {
		myProperties = properties;
		myLevels = levelsView;
	}

	@Override
	public void handle(MouseEvent event) {
		GameObjectGraphic g = (GameObjectGraphic) event.getSource();
		double x = event.getSceneX();
		double y = event.getSceneY();
		myLevels.addGameObjectToView(g, x, y, new GraphicsDragHandler(myProperties,
				myLevels), new GameObjectClickHandler(myProperties));

	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_RELEASED;
	}

}