package authoring.eventhandlers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import authoring.view.graphicsview.Graphic;
import authoring.view.levelview.LevelsView;
import authoring.view.propertiesview.PropertiesView;

/**
 * Handles user click on graphic objects. Projects graphic properties in
 * PropertiesView and/or creates copy of selected graphic on the active level.
 * 
 * @author Wesley Valentine
 *
 */
public class GraphicsEventHandler implements EventHandler<MouseEvent> {
	private PropertiesView myProperties;
	private LevelsView myLevels;

	public GraphicsEventHandler(PropertiesView properties, LevelsView levels) {
		myProperties = properties;
		myLevels = levels;
	}

	@Override
	public void handle(MouseEvent event) {
		Graphic g = (Graphic) event.getSource();
		myProperties.fillContents(g);
		double x = event.getSceneX();
		double y = event.getSceneY();
		myLevels.addSpriteToView(g, x, y, new GraphicsDragHandler(myProperties,
				myLevels));

	}

}