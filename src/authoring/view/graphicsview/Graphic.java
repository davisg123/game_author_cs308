package authoring.view.graphicsview;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Graphic extends VBox {

	private String myName;
	private EventHandler<MouseEvent> myOnClick;
	private boolean myIsVisible = true;

	public boolean getVisible() {
		return myIsVisible;
	}

	public Graphic(String s, EventHandler<MouseEvent> event) {
		myName = s;
		myOnClick = event;
	}

	public void makeGraphic(EventType<MouseEvent> event) {
		Image image = new Image(getClass().getResourceAsStream(myName));
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(70);
		imageView.setFitWidth(70);
		this.getChildren().add(imageView);
		this.getChildren().add(new Text(myName));

		this.addEventFilter(event, myOnClick);

	}

	public String getName() {
		return myName;
	}

}
