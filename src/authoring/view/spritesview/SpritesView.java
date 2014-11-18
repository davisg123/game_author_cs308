package authoring.view.spritesview;

import java.util.ResourceBundle;

import javafx.scene.text.Text;
import authoring.view.baseclasses.ScrollView;

/**
 * View component for the backend model data - SpritesCollection. Updates
 * automatically if changes occur in SpritesCollection via observer.
 * 
 * @author Kevin Li
 *
 */
public class SpritesView extends ScrollView {

	private static final double VIEW_HEIGHT_RATIO = .95;
	private static final double VIEW_WIDTH_RATIO = 0.2;

	public SpritesView(ResourceBundle language, double width, double height) {
		super(language, width, height);
		setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
	}

}
