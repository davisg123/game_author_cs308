package authoring.view.baseclasses;

import javafx.scene.layout.BorderPane;

/**
 * Base class that other classes can extend to make BorderPanes.
 * 
 * @author Kevin Li
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Arjun Jain
 */
public class BPContainer extends BorderPane {

	public BPContainer(double width, double height) {
		setView(width, height);
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
