package authoring.controller;

import java.util.ResourceBundle;

import javafx.geometry.Pos;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import authoring.model.AuthoringModel;
import authoring.view.AuthoringView;
import authoring.view.baseclasses.AccordianView;
import authoring.view.graphicsview.GraphicsView;
import authoring.view.levelview.LevelsView;
import authoring.view.propertiesview.PropertiesView;
import authoring.view.soundsview.SoundsView;
import authoring.view.spritesview.SpritesView;

public class AuthoringController {
	private AuthoringView myView;
	private AuthoringModel myModel;
	private ResourceBundle myLanguage;

	private LevelsView myLevels;
	private SpritesView mySprites;
	private GraphicsView myGraphics;
	private SoundsView mySounds;
	private PropertiesView myProperties;
	private double myWidth;
	private double myHeight;

	public AuthoringController(AuthoringView view, AuthoringModel model,
			double width, double height, ResourceBundle language) {
		myView = view;
		myModel = model;
		myWidth = width;
		myHeight = height;
		myLanguage = language;
		initializeView();

	}

	private void initializeView() {
		initializeViewComponents();
		myView.setCenter(myLevels);
		myView.setLeft(initializeLeft());
		myView.setRight(initializeRight());

	}

	private void initializeViewComponents() {
		myLevels = new LevelsView(myLanguage, myWidth, myHeight);
		mySounds = new SoundsView(myLanguage, myWidth, myHeight);
		myGraphics = new GraphicsView(myLanguage, myWidth, myHeight);
		myGraphics.setAction(event -> graphicsOnClick(myGraphics));
		myProperties = new PropertiesView(myLanguage, myWidth, myHeight);
		mySprites = new SpritesView(myLanguage, myWidth, myHeight);

	}
	
	//TEMPORARY HARDCODE - learning to drag javafx objects
	//should be in controller to interact with other objects on GUI
	private void graphicsOnClick(GraphicsView g){
		myProperties.fillContents(g);
	}
	

	private AccordianView initializeLeft() {
		AccordianView leftView = new AccordianView(myWidth, myHeight);
		String im = "mario.png";
		
		myModel.getImages().addObserver(myGraphics);
		myModel.getImages().addImage(im);
		

		TitledPane graphics = new TitledPane(myLanguage.getString("Graphics"),
				myGraphics);
		
		
		TitledPane sounds = new TitledPane(myLanguage.getString("Sounds"),
				mySounds);
		TitledPane sprites = new TitledPane(myLanguage.getString("Sprites"),
				mySprites);


		leftView.getPanes().addAll(graphics, sounds, sprites);
		BorderPane.setAlignment(leftView, Pos.TOP_RIGHT);
		
		return leftView;
	}

	private TitledPane initializeRight() {
		//AccordianView rightView = new AccordianView(myWidth, myHeight);
		TitledPane properties = new TitledPane(myLanguage.getString("Properties"), myProperties);
		properties.setCollapsible(false);
		//rightView.getPanes().addAll(properties);
		return properties;
	}

}
