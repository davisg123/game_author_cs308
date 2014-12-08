package authoring.view.propertiesview;

import java.util.ResourceBundle;

import javafx.scene.layout.VBox;
import authoring.eventhandlers.AddConditionIDHandler;
import authoring.eventhandlers.GameHandler;
import authoring.view.baseclasses.CollectionView;
import authoring.view.icons.ConditionIcon;
import authoring.view.icons.ImageIcon;
import authoring.view.icons.LevelIcon;
import authoring.view.icons.SoundIcon;
import engine.conditions.Condition;
import engine.gameObject.GameObject;

public class PropertiesView extends CollectionView {

	private static final double VIEW_HEIGHT_RATIO = .95;
	private static final double VIEW_WIDTH_RATIO = 0.2;
	private VBox myContents = new VBox();

	private GameHandler[] myButtonBehaviors;
	private GameHandler myAddActionButtonBehavior;

	private GameObjectProperties myGameObjectsProperties;
	private GameObject myCurrentGameObject;
	private Condition myCurrentCondition;

	private double myWidth;
	private double myHeight;

	public PropertiesView(ResourceBundle language, double width, double height) {
		super(language, width, height);
		setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
		this.setContent(myContents);

		myWidth = width;
		myHeight = height;

	}

	// public void makeProperties(Graphic g){
	// g.makeProperties();
	// }

	public void makeProperties(ImageIcon g) {
		myContents.getChildren().clear();
		this.setContent(new FileProperties(g));
	}

	public void makeProperties(SoundIcon g) {
		myContents.getChildren().clear();
		this.setContent(new FileProperties(g));
	}

	public void makeProperties(GameObject gameObj) {
		myContents.getChildren().clear();
		myCurrentGameObject = gameObj;
		myGameObjectsProperties = new GameObjectProperties(gameObj, myWidth,
				myHeight, this.myButtonBehaviors);
		this.setContent(myGameObjectsProperties);
	}

	public void makeProperties(LevelIcon g) {
		LevelProperties props = new LevelProperties(g, new AddConditionIDHandler(g.getLevel()));
		myContents.getChildren().clear();
		this.setContent(props);
	}

	public void makeProperties(ConditionIcon g) {
		myContents.getChildren().clear();
		this.setContent(new ConditionProperties(g, myAddActionButtonBehavior));
	}

	public void displayProperties(Properties props) {
		this.setContent(props);
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
	public void setAddActionButtonBehaviors(GameHandler gh) {
		myAddActionButtonBehavior = gh;
	}

}
