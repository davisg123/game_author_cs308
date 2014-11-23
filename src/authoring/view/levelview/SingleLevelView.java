package authoring.view.levelview;

import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

import engine.gameObject.GameObject;
import engine.level.Level;
import authoring.eventhandlers.GameHandler;
import authoring.eventhandlers.GameObjectClickHandler;
import authoring.eventhandlers.GameObjectDragHandler;
import authoring.view.gameobjectsview.GameObjectGraphic;
import authoring.view.graphicsview.Graphic;
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
	private GameHandler[] myEvents;
	private String myID;

	public SingleLevelView(double width, double height, GameHandler... handlers) {
		this.setBackground(myDefaultBackground);
		setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
		myEvents = handlers;
	}

	private void setView(double width, double height) {
		setPrefSize(width, height);
		setMinSize(width, height);
		setMaxSize(width, height);
	}

	@Override
	public void update(Observable o, Object arg) {
			Level level = ((Level) arg);
			this.getChildren().clear();
			//System.out.println(level.getGameObjectsCollection());
			//level.getGameObjectsCollection().clear();
			//System.out.println(level.getLevelID());
			for (GameObject g: level.getGameObjectsCollection()){
				//removeGameObjectFromView(g);
				addGameObjectToView(g, g.getX(), g.getY(), myEvents);
			}
	}

	private void addGameObjectToView(GameObject gameObject, double x, double y,
			GameHandler... handler) {
		GameObjectGraphic g = new GameObjectGraphic(gameObject, handler);
		g.makeGraphic();
		g.setLayoutX(x - 230);
		g.setLayoutY(y - 100);
		this.getChildren().add(g);

	}

	/**
	public void removeGameObjectFromView(GameObject gameObject) {
		GameObjectGraphic g = new GameObjectGraphic(gameObject, myEvents);
		System.out.println(this.getChildren().contains(g));
		this.getChildren().remove(g);
	}
	**/
	
	public void setID(String ID) {
		myID = ID;
	}

	public String getID() {
		return myID;
	}

	public void moveSpriteOnLevel(Graphic g, double x, double y) {
		g.setLayoutX(x - 230);
		g.setLayoutY(y - 100);
	}

}
