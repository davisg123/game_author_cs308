package authoring.view.propertiesview;

import java.io.File;
import java.util.ResourceBundle;

import javafx.scene.layout.VBox;
import authoring.eventhandlers.GameHandler;
import authoring.view.baseclasses.ScrollView;
import authoring.view.graphicsview.Graphic;
import engine.gameObject.GameObject;

public class PropertiesView extends ScrollView{

	
	private static final double VIEW_HEIGHT_RATIO = .95;
	private static final double VIEW_WIDTH_RATIO = 0.2;
	private VBox myContents = new VBox();	
	
	private GameHandler myEditBehavior;
	private GameHandler mySaveAsNewBehavior;
	
	private GameObjectsProperties myGameObjectsProperties;
	private GameObject myCurrentGameObject;
	private File myGameLocation;
	
	
	public PropertiesView(ResourceBundle language, double width, double height, File gameLoc) {
		super(language, width, height);
		setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
		this.setContent(myContents);
		myGameLocation = gameLoc;
	}
	
	public void makeProperties(Graphic g){
		myContents.getChildren().clear();
		this.setContent(new GraphicsProperties(g));
	}
	
	public void makeProperties(GameObject gameObj){
		myContents.getChildren().clear();
		myCurrentGameObject = gameObj;
		myGameObjectsProperties = new GameObjectsProperties(gameObj, this.myEditBehavior, myGameLocation);
		this.setContent(myGameObjectsProperties);
	}
	
	public GameObject getCurrentGameObject(){
		return this.myCurrentGameObject;
	}
	
	public GameObject getEditedGameObject(){
		return this.myGameObjectsProperties.edit(this.myCurrentGameObject);
	}
	
	public void setEditButtonBehavior(GameHandler gh){
		myEditBehavior = gh;
	}
	
	public void setSaveAsNewButtonBehavior(GameHandler gh){
		mySaveAsNewBehavior = gh;
	}
	
}
