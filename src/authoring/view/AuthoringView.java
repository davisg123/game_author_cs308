package authoring.view;

import javafx.scene.layout.BorderPane;

public class AuthoringView extends BorderPane {
	private static final double VIEW_HEIGHT_RATIO = .92;

	public AuthoringView(double width, double height) {
		setVisible(true);
		setView(width, height * VIEW_HEIGHT_RATIO);
	}

	/**
	 * Sets the correct size of the view. Is code that is replicated throughout
	 * the program. If there is a way to extract, that would be useful.
	 * 
	 * @param width
	 *            Width the view is to be set at.
	 * @param height
	 *            Height the view is to be set at.
	 */
	private void setView(double width, double height) {
		setPrefSize(width, height);
		setMinSize(width, height);
		setMaxSize(width, height);
	}

}
