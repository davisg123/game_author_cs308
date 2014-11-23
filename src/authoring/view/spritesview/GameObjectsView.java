package authoring.view.spritesview;

import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import authoring.view.baseclasses.ScrollView;
import authoring.view.graphicsview.Graphic;

/**
 * View component for the backend model data - SpritesCollection. Updates
 * automatically if changes occur in SpritesCollection via observer.
 * 
 * @author Kevin Li
 *
 */
public class GameObjectsView extends ScrollView implements Observer {

	private static final double VIEW_HEIGHT_RATIO = .95;
	private static final double VIEW_WIDTH_RATIO = 0.2;
	private EventHandler<MouseEvent> myOnClick;
	private VBox myVbox = new VBox();	

	public GameObjectsView(ResourceBundle language, double width, double height, EventHandler<MouseEvent> action) {
		super(language, width, height);
		setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
		myOnClick = action;
		this.setContent(myVbox);
	}

	@Override
	public void update(Observable o, Object arg) {
		addSprite((String) arg, myOnClick);
	}

	private void addSprite(String s, EventHandler<MouseEvent> handler) {
		Graphic graphic = new Graphic(s, handler);
		graphic.makeGraphic(MouseEvent.MOUSE_CLICKED);
		myVbox.getChildren().add(graphic);
	}
	
	

}
