package authoring.view.baseclasses;

import java.util.ResourceBundle;

import javafx.scene.layout.BorderPane;

/**
 * Base class that other classes can extend to make BorderPanes.
 * 
 * @author Kevin Li
 *
 */
public class BPView extends BorderPane {
	protected ResourceBundle myLanguage;
	protected double myHeight;
	protected double myWidth;

	public BPView(ResourceBundle language, double width, double height) {
		myLanguage = language;
		myHeight = height;
		myWidth = width;
	}

	/**
	 * Method that sets the size of the view. Code that is duplicated in every
	 * view at the highest shared inheritance level.
	 * 
	 * @param width
	 *            Width the view is to be set at.
	 *
	 * @param height
	 *            Height the view is to be set at.
	 */
	protected void setView(double width, double height) {
		setPrefSize(width, height);
		setMinSize(width, height);
		setMaxSize(width, height);
	}

}
