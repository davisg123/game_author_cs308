package authoring.view.graphicsview;

import java.util.Collection;

import authoring.eventhandlers.GameHandler;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Represents an image, but does not instantiate JavaFX object so that the
 * object can easily be serialized if necessary.
 * 
 * @author Chris Bernt
 * @author Kevin Li
 * @author Arjun Jain
 * @author Wesley Valentine
 *
 */
public class Graphic extends VBox {

	private String myName;
	private GameHandler[] myOnClick;
	private boolean myIsVisible = true;

	public boolean getVisible() {
		return myIsVisible;
	}

	public Graphic(String s, GameHandler ... event) {
		myName = s;
		myOnClick = event;
	}

	/**
	 * creates an instance of the JavaFX object that can be displayed on the
	 * GUI. Takes in a MouseEvent so that the graphic will respond to the
	 * specified events.
	 * 
	 * @param event
	 */
	public void makeGraphic() {
		Image image = new Image(getClass().getResourceAsStream(myName));
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(70);
		imageView.setFitWidth(70);
		this.getChildren().add(imageView);
		this.getChildren().add(new Text(myName));
		for(int x = 0; x < myOnClick.length; x++){
			this.addEventFilter(myOnClick[x].getEventType(), myOnClick[x]);
		}
	}

	public String getName() {
		return myName;
	}

}
