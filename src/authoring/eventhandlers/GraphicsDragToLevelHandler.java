package authoring.eventhandlers;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.model.AuthoringModel;
import authoring.model.collections.LevelsCollection;
import authoring.view.graphicsview.Graphic;
import authoring.view.levelview.LevelsView;
import authoring.view.propertiesview.PropertiesView;

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
		Graphic g = (Graphic) event.getSource();
		double x = event.getSceneX();
		double y = event.getSceneY();
		myLevels.addSpriteToView(g, x, y, new GraphicsDragHandler(myProperties,
				myLevels), new GraphicsClickHandler(myProperties, myLevels));

	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_RELEASED;
	}

}