package authoring.view;

import authoring.view.baseclasses.BPContainer;

/**
 * Borderpane that holds the view.
 * 
 * @author Kevin Li
 *
 */
public class AuthoringView extends BPContainer {

	private static final double VIEW_HEIGHT_RATIO = .92;

	public AuthoringView(double width, double height) {
		super(width, height*VIEW_HEIGHT_RATIO);
		setVisible(true);
	}
}
