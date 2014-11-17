package authoring.view.baseclasses;

import java.util.ResourceBundle;

import javafx.scene.control.ScrollPane;

/**
 * Base class other classes can extend to make ScrollPanes.
 * 
 * @author Kevin Li
 *
 */
public class ScrollView extends ScrollPane {
	protected ResourceBundle myLanguage;
	protected double myHeight;
	protected double myWidth;

	public ScrollView(ResourceBundle language, double width, double height) {
		myLanguage = language;
		myHeight = height;
		myWidth = width;
	}

	protected void setView(double width, double height) {
		setPrefSize(width, height);
		setMinSize(width, height);
		setMaxSize(width, height);
	}
}