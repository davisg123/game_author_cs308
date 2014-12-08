package authoring.view.baseclasses;

import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.scene.control.ScrollPane;
import authoring.eventhandlers.GameHandler;

/**
 * Base class other classes can extend to make ScrollPanes.
 * 
 * @author Kevin Li
 *
 */
public class CollectionView extends ScrollPane {
	protected ResourceBundle myLanguage;
	protected double myHeight;
	protected double myWidth;
	protected GameHandler[] myIconEvents;

	public CollectionView(ResourceBundle language, double width, double height) {
		myLanguage = language;
		myHeight = height;
		myWidth = width;
	}

	protected void setView(double width, double height) {
		setPrefSize(width, height);
		setMinSize(width, height);
		setMaxSize(width, height);
	}
	
	public void setIconEvents(GameHandler ... gameHandlers){
		myIconEvents = gameHandlers;
	}
}