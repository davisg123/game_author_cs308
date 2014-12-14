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

	public void setController(AuthoringController controller) {
		myController = controller;
	}

	public AuthoringController getController() {
		return myController;
	}
}
