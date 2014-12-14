package authoring.view;

import authoring.controller.AuthoringController;
import authoring.view.baseclasses.BPContainer;

/**
 * Borderpane that holds the view.
 * 
 * @author Kevin Li
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Arjun Jain
 */
public class AuthoringView extends BPContainer {

	private static final double VIEW_HEIGHT_RATIO = .92;
	private AuthoringController myController;

	public AuthoringView(double width, double height) {
		super(width, height * VIEW_HEIGHT_RATIO);
		setVisible(true);
	}

	/**
	 * Controller setting method that is used in order to retrieve the right
	 * controller when saving and loading a file.
	 * 
	 * @param controller
	 *            AuthoringController associated with the view.
	 */
	public void setController(AuthoringController controller) {
		myController = controller;
	}

	/**
	 * Controller retrieving method that is used in order to retrieve the right
	 * controller when saving and loading a file.
	 * 
	 * @return controller AuthoringController associated with the view.
	 */

	public AuthoringController getController() {
		return myController;
	}
}
