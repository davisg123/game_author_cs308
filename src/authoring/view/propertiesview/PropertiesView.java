package authoring.view.propertiesview;

import java.util.ResourceBundle;

import javafx.scene.layout.VBox;
import authoring.eventhandlers.GameHandler;
import authoring.view.baseclasses.CollectionView;
import authoring.view.icons.IPropertiesMaker;
import engine.gameObject.GameObject;

/**
 * @author Kevin Li
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Arjun Jain
 */
public class PropertiesView extends CollectionView {

	private static final double VIEW_HEIGHT_RATIO = .95;
	private static final double VIEW_WIDTH_RATIO = 0.2;
	private VBox myContents = new VBox();

	private GameHandler[] myButtonBehaviors;

	private GameObjectProperties myGameObjectsProperties;
	private GameObject myCurrentGameObject;

	private double myWidth;
	private double myHeight;

	public PropertiesView(ResourceBundle language, double width, double height) {
		super(language, width, height);
		setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
		this.setContent(myContents);

		myWidth = width;
		myHeight = height;

	}

	/**
	 * The icon (that must implement IPropertiesMaker) to display properties
	 * for.
	 * 
	 * @param icon
	 */
	public void displayProperties(IPropertiesMaker icon) {
		myContents.getChildren().clear();
		this.setContent(icon.makeProperties());
	}

	/**
	 * This method was overloaded since it is being used in several handlers
	 * besides the click handler that only have access to a particular game
	 * object and not the game object icon. The game object can be taken from
	 * the icon, but creating an icon from solely a game object is difficult.
	 * 
	 * @param gameObj
	 *            The game object to make properties for.
	 */
	public void displayProperties(GameObject gameObj) {
		myContents.getChildren().clear();
		myCurrentGameObject = gameObj;
		myGameObjectsProperties = new GameObjectProperties(gameObj, myWidth,
				myHeight, this.myButtonBehaviors);
		this.setContent(myGameObjectsProperties);
	}

	public GameObject getCurrentGameObject() {
		return this.myCurrentGameObject;
	}

	public GameObject getEditedGameObject() {
		return this.myGameObjectsProperties.edit(this.myCurrentGameObject);
	}

	public void setButtonBehaviors(GameHandler... gh) {
		myButtonBehaviors = gh;
	}

}
