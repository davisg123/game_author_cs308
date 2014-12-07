package authoring.view.propertiesview;

import java.util.ResourceBundle;

import javafx.scene.layout.VBox;
import authoring.eventhandlers.GameHandler;
import authoring.view.baseclasses.ScrollView;
import authoring.view.icons.BaseIcon;
import authoring.view.icons.GameObjectIcon;
import engine.gameObject.GameObject;

public class PropertiesView extends ScrollView {

	private static final double VIEW_HEIGHT_RATIO = .95;
	private static final double VIEW_WIDTH_RATIO = 0.2;
	private VBox myContents = new VBox();

	private GameHandler[] myButtonBehaviors;

	private GameObjectProperties myGameObjectsProperties;
	private BaseIcon myCurrentIcon;
	
	private double myWidth;
	private double myHeight;

	public PropertiesView(ResourceBundle language, double width, double height) {
		super(language, width, height);
		setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
		this.setContent(myContents);
		
		myWidth = width;
		myHeight = height;
		
	}

//	public void makeProperties(Graphic g){
//		g.makeProperties();
//	}
//	public void makeProperties(ImageIcon g) {
//		myContents.getChildren().clear();
//		this.setContent(new ImageProperties(g));
//	}
//
//	public void makeProperties(GameObjectIcon gameObj) {
//		myContents.getChildren().clear();
//		myCurrentGameObject = gameObj.getGameObject();
//		myGameObjectsProperties = new GameObjectProperties(gameObj,this.myButtonBehaviors);
//		this.setContent(myGameObjectsProperties);
//	}
//	
//	public void makeProperties(LevelIcon g){
//		myContents.getChildren().clear();
//		this.setContent(new LevelProperties(g));
//	}
	
	/**
	public <T> void makeProperties(T g){
		myContents.getChildren().clear();
		try{
			String classString = g.getClass().toString();
			String className = classString.split("\\.")[classString.split("\\.").length-1];
			String type = className.replace("Icon", "");
			Class cl = Class.forName("authoring.view.propertiesview." + type + "Properties");
			Constructor ct = cl.getConstructor(g.getClass(), this.myButtonBehaviors.getClass());
			this.setContent((Node) ct.newInstance(g, this.myButtonBehaviors));
		}
		catch (Exception e){
			System.out.println("Broken");
			//e.printStackTrace();
		}
	}
	**/
	public void displayProperties(Properties props){
		this.setContent(props);
	}
	
	public GameObjectIcon getCurrentIcon() {
		return (GameObjectIcon) this.myCurrentIcon;
	}

	public GameObject getEditedGameObject() {
		return this.myGameObjectsProperties.edit(this.getCurrentIcon().getGameObject());
	}

	public void setButtonBehaviors(GameHandler ...gh) {
		myButtonBehaviors = gh;
	}

}
