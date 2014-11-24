package authoring.view.levelview;

import java.io.File;
import java.util.Arrays;

import data.Observable;
import data.Observer;
import engine.gameObject.GameObject;
import engine.level.Level;
import authoring.eventhandlers.GameHandler;
import authoring.eventhandlers.GameObjectClickHandler;
import authoring.eventhandlers.GameObjectDragHandler;
import authoring.main.Main;
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
	private static final double VIEW_HEIGHT_RATIO = .82;
	private static final double VIEW_WIDTH_RATIO = 0.6;
	public static final double OBJECT_X_OFFSET = -Main.SCREEN_WIDTH*.2;
	public static final double OBJECT_Y_OFFSET = -Main.SCREEN_HEIGHT*.202;
	private File myGameLocation;

	private GameHandler[] myEvents;
	private String myID;
	private double myViewWidth;
	private double myViewHeight;

	public SingleLevelView(File gameLoc, double width, double height,
			GameHandler... handlers) {
		this.setBackground(myDefaultBackground);
		setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
		myEvents = handlers;
		myGameLocation = gameLoc;
	}

	/**
	 * @param width
	 * @param height
	 * @param l
	 * @param handlers
	 */
	public SingleLevelView(File gameLoc, double width, double height, Level l, GameHandler... handlers){
		this(gameLoc, width,height, handlers);

		recreateLevel(l);
	}

	private void setView(double width, double height) {
		this.myViewWidth = width;
		this.myViewHeight = height;
		setPrefSize(width, height);
		setMinSize(width, height);
		setMaxSize(width, height);
	}

	public void recreateLevel(Level l) {
		// System.out.println(myEvents.length);
		for (GameObject g : l.getGameObjectsCollection()) {
			addGameObjectToView(g, g.getX(), g.getY(), myEvents);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		Level level = ((Level) arg);
		this.getChildren().clear();
		// System.out.println(level.getGameObjectsCollection());
		// level.getGameObjectsCollection().clear();
		// System.out.println(level.getLevelID());
		recreateLevel(level);
	}

	private void addGameObjectToView(GameObject gameObject, double x, double y,
			GameHandler... handler) {
		GameObjectGraphic g = new GameObjectGraphic(gameObject, handler);
		g.makeGraphic(myGameLocation);
		this.moveSpriteOnLevel(g, x, y);
		this.getChildren().add(g);

	}

	/**
	 * public void removeGameObjectFromView(GameObject gameObject) {
	 * GameObjectGraphic g = new GameObjectGraphic(gameObject, myEvents);
	 * System.out.println(this.getChildren().contains(g));
	 * this.getChildren().remove(g); }
	 **/

	public void setID(String ID) {
		myID = ID;
	}

	public String getID() {
		return myID;
	}

	public void moveSpriteOnLevel(Graphic g, double x, double y) {
		g.setLayoutX(x + OBJECT_X_OFFSET);
		g.setLayoutY(y + OBJECT_Y_OFFSET);
	}

	public double getViewWidth()
	{
		return this.myViewWidth;
	}
	
	public double getViewHeight()
	{
		return this.myViewHeight;
	}
}
