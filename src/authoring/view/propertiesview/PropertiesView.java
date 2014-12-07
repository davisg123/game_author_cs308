package authoring.view.propertiesview;

import java.util.ResourceBundle;

import javafx.scene.Node;
import javafx.scene.layout.VBox;
import authoring.eventhandlers.GameHandler;
import authoring.view.baseclasses.ScrollView;
import authoring.view.icons.ImageIcon;
import authoring.view.icons.LevelIcon;
import engine.gameObject.GameObject;

public class PropertiesView extends ScrollView {

	private static final double VIEW_HEIGHT_RATIO = .95;
	private static final double VIEW_WIDTH_RATIO = 0.2;
	private VBox myContents = new VBox();

	private GameHandler[] myButtonBehaviors;

	private GameObjectProperties myGameObjectsProperties;
	private GameObject myCurrentGameObject;

	public PropertiesView(ResourceBundle language, double width, double height) {
		super(language, width, height);
		setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
		this.setContent(myContents);

	}

//	public void makeProperties(Graphic g){
//		g.makeProperties();
//	}
	
	public void makeProperties(ImageIcon g) {
		myContents.getChildren().clear();
		this.setContent(new ImageProperties(g));
	}

	public void makeProperties(GameObject gameObj) {
		myContents.getChildren().clear();
		myCurrentGameObject = gameObj;
		myGameObjectsProperties = new GameObjectProperties(gameObj,
				this.myButtonBehaviors);
		this.setContent(myGameObjectsProperties);
	}
	
	public void makeProperties(LevelIcon g){
		myContents.getChildren().clear();
		this.setContent(new LevelProperties(g));
	}

	public void displayProperties(Properties props){
		this.setContent(props);
	}
	
	public GameObject getCurrentGameObject() {
		return this.myCurrentGameObject;
	}

	public GameObject getEditedGameObject() {
		return this.myGameObjectsProperties.edit(this.myCurrentGameObject);
	}

	public void setButtonBehaviors(GameHandler ...gh) {
		myButtonBehaviors = gh;
	}

}
