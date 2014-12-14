package authoring.view.gameobjectsview;

import java.io.File;
import java.util.ResourceBundle;

import javafx.scene.layout.VBox;
import authoring.eventhandlers.GameHandler;
import authoring.view.baseclasses.CollectionView;
import authoring.view.icons.GameObjectIcon;
import data.Observable;
import data.Observer;
import engine.gameObject.GameObject;

/**
 * View component for the backend model data - SpritesCollection. Updates
 * automatically if changes occur in SpritesCollection via observer.
 * 
 * @author Kevin Li
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Arjun Jain
 */
public class GameObjectsView extends CollectionView implements Observer {

	private static final double VIEW_HEIGHT_RATIO = .65;
	private static final double VIEW_WIDTH_RATIO = 0.2;
	private VBox myVbox = new VBox();
	private File myGameLocation;

	public GameObjectsView(ResourceBundle language, double width,
			double height, File gameLoc) {
		super(language, width, height);
		setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
		this.setContent(myVbox);
		myGameLocation = gameLoc;
	}

	@Override
	public void update(Observable o, Object arg) {
		addGameObject((GameObject) arg, myIconEvents);
	}

	@SuppressWarnings("unchecked")
	private void addGameObject(GameObject gameObject, GameHandler... handler) {
		GameObjectIcon graphic = new GameObjectIcon(gameObject, myGameLocation,
				handler);
		graphic.scaleDimensions();
		myVbox.getChildren().add(graphic);
	}

}
