package authoring.view;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class LevelsView extends Pane {
	private Background myDefaultBackground = new Background(new BackgroundFill(
			Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY));
	private static final double VIEW_HEIGHT_RATIO = .92;
	private static final double VIEW_WIDTH_RATIO = 0.6;

	public LevelsView(double width, double height) {
		this.setBackground(myDefaultBackground);
		setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);

	}

	/**
	 * Method that sets the size of the view. Code that is duplicated in every
	 * view at the highest shared inheritance level.
	 * 
	 * @param width
	 *            Width to be set at.
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
