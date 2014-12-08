package authoring.view.levelview;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import authoring.eventhandlers.GameHandler;
import authoring.main.Main;
import authoring.view.icons.GameObjectIcon;
import authoring.view.icons.ImageBasedIcon;
import data.Observable;
import data.Observer;
import engine.gameObject.GameObject;
import engine.level.Level;

/**
 * Class that contains the visualization data of a single level.
 * 
 * @author Kevin Li
 *
 */
public class SingleLevelView extends Pane implements Observer {
	private Background myDefaultBackground = new Background(new BackgroundFill(
			Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY));
	private static final double VIEW_HEIGHT_RATIO = .82;
	private static final double VIEW_WIDTH_RATIO = 0.6;
	public static final double OBJECT_X_OFFSET = -Main.SCREEN_WIDTH * .2;
	public static final double OBJECT_Y_OFFSET = -Main.SCREEN_HEIGHT * .23;
	private File myGameLocation;

	private GameHandler[] myEvents;
	private String myID;
	private double myViewWidth;
	private double myViewHeight;
	private String myBackgroundImage;

	public SingleLevelView(File gameLoc, double width, double height,
			String bgImage, GameHandler... handlers) {
		setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
		myEvents = handlers;
		myGameLocation = gameLoc;
		this.setBackground(myDefaultBackground);
		
		File file = new File(myGameLocation.getPath() + "/images/" + bgImage);
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(file);
			Image image = SwingFXUtils.toFXImage(bufferedImage, null);
			BackgroundImage backgroundImage = new BackgroundImage(image, null,
					null, null, null);
			Background background = new Background(backgroundImage);
			this.setBackground(background);
			System.out.println("hit");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Not an image selected for background");
		}

	}

	/**
	 * @param width
	 * @param height
	 * @param l
	 * @param handlers
	 */
	public SingleLevelView(File gameLoc, double width, double height, Level l,
			GameHandler... handlers) {
		this(gameLoc, width, height, l.getBackgroundImage(), handlers);

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
		GameObjectIcon g = new GameObjectIcon(gameObject, myGameLocation,
				handler);
		// System.out.println(gameObject.getWidth() + " " +
		// gameObject.getHeight() + " " + gameObject.getRotation());
		g.setDimensions(gameObject.getWidth(), gameObject.getHeight(),
				gameObject.getRotation());

		this.moveGameObjectToLevel(g, x, y);
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

	public void moveGameObjectToLevel(ImageBasedIcon g, double x, double y) {
		g.setLayoutX(x + OBJECT_X_OFFSET);
		g.setLayoutY(y + OBJECT_Y_OFFSET);
	}

	public double getViewWidth() {
		return this.myViewWidth;
	}

	public double getViewHeight() {
		return this.myViewHeight;
	}
}
