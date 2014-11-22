package authoring.view.levelview;

import java.util.Observable;
import java.util.Observer;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * Class that contains the visualization data of a single level.
 * 
 * @author Kevin Li
 *
 */
public class SingleLevelView extends Pane implements Observer {
	private Background myDefaultBackground = new Background(new BackgroundFill(
			Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY));
	private static final double VIEW_HEIGHT_RATIO = .85;
	private static final double VIEW_WIDTH_RATIO = 0.6;

	public SingleLevelView(double width, double height) {
		this.setBackground(myDefaultBackground);
		setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
	}

	private void setView(double width, double height) {
		setPrefSize(width, height);
		setMinSize(width, height);
		setMaxSize(width, height);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
}
