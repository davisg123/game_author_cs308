package authoring.view;

import java.util.ResourceBundle;

import authoring.view.baseclasses.BPView;

/**
 * Borderpane that holds the view.
 * 
 * @author Kevin Li
 *
 */
public class AuthoringView extends BPView {

	private static final double VIEW_HEIGHT_RATIO = .92;

	public AuthoringView(ResourceBundle language, double width, double height) {
		super(language, width, height);
		setVisible(true);
		setView(super.myWidth, super.myHeight * VIEW_HEIGHT_RATIO);
	}
}
