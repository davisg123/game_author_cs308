package authoring.view.gameobjectsview;

import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.scene.layout.VBox;
import authoring.eventhandlers.GameHandler;
import authoring.view.baseclasses.ScrollView;
import authoring.view.graphicsview.Graphic;
import engine.gameObject.GameObject;

/**
 * View component for the backend model data - SpritesCollection. Updates
 * automatically if changes occur in SpritesCollection via observer.
 * 
 * @author Kevin Li
 *
 */
public class GameObjectsView extends ScrollView implements Observer {

	private static final double VIEW_HEIGHT_RATIO = .74;
	private static final double VIEW_WIDTH_RATIO = 0.2;
	private VBox myVbox = new VBox();	

	public GameObjectsView(ResourceBundle language, double width, double height) {
		super(language, width, height);
		setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
		this.setContent(myVbox);
	}

	@Override
	public void update(Observable o, Object arg) {
		addGameObject((GameObject) arg, myEvents);
	}

	@SuppressWarnings("unchecked")
	private void addGameObject(GameObject gameObject, GameHandler ... handler) {
		Graphic graphic = new GameObjectGraphic(gameObject, handler);
		graphic.makeGraphic();
		myVbox.getChildren().add(graphic);
	}
	
}
