package authoring.controller;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.geometry.Pos;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import authoring.eventhandlers.GraphicsClickHandler;
import authoring.eventhandlers.GraphicsDragToLevelHandler;
import authoring.model.AuthoringModel;
import authoring.view.AuthoringView;
import authoring.view.baseclasses.AccordianView;
import authoring.view.graphicsview.GraphicsView;
import authoring.view.levelview.LevelsView;
import authoring.view.levelview.SingleLevelView;
import authoring.view.propertiesview.PropertiesView;
import authoring.view.soundsview.SoundsView;
import authoring.view.spritesview.GameObjectsView;
import engine.actions.Action;
import engine.conditions.Condition;
import engine.gameObject.GameObject;
import engine.gameObject.components.Component;

/**
 * Controller class that interacts between model and view. Holds and constructs
 * all the view components in order to allow communication between them. Allows
 * the Model and View to exchange data without knowledge of each other.
 * 
 * @author Kevin Li
 * @author Wesley Valentine
 * @author Chris Bernt
 * @author Arjun Jain
 *
 */
public class AuthoringController {
	private AuthoringView myView;
	private AuthoringModel myModel;
	private ResourceBundle myLanguage;
	private double myWidth;
	private double myHeight;

	/**
	 * Contains front-end representations of all Game Data stored in the
	 * back-end; Levels, Sprites, Graphics, Sounds
	 */
	private LevelsView myLevels;
	private GameObjectsView myGameObjects;
	private GraphicsView myGraphics;
	private SoundsView mySounds;
	private PropertiesView myProperties;

	public AuthoringController(AuthoringView view, AuthoringModel model,
			double width, double height, ResourceBundle language) {
		myView = view;
		myModel = model;
		myWidth = width;
		myHeight = height;
		myLanguage = language;
		initializeView();

	}

	/**
	 * Sets the contents of the AuthoringView - which is essentially an empty
	 * borderpane.
	 */

	private void initializeView() {
		initializeViewComponents();
		myView.setCenter(myLevels);
		myView.setLeft(initializeLeft());
		myView.setRight(initializeRight());

	}

	/**
	 * Initializes all the view components that have a 1 to 1 relationship with
	 * backend data components. Provides event handlers for View objects to
	 * handle sending data to the backend
	 */

	private void initializeViewComponents() {
		myLevels = new LevelsView(myLanguage, myWidth, myHeight);
		mySounds = new SoundsView(myLanguage, myWidth, myHeight);
		myProperties = new PropertiesView(myLanguage, myWidth, myHeight);
		myGraphics = new GraphicsView(myLanguage, myWidth, myHeight,
				new GraphicsDragToLevelHandler(myProperties, myLevels), new GraphicsClickHandler(myProperties, myLevels));
		myGameObjects = new GameObjectsView(myLanguage, myWidth, myHeight,
				new GraphicsDragToLevelHandler(myProperties, myLevels));

	}

	/**
	 * Initializes what goes on the left side of the borderpane.
	 * 
	 * @return AccordianView a node.
	 */

	private AccordianView initializeLeft() {
		AccordianView leftView = new AccordianView(myWidth, myHeight);

		// Some hard-coded images used to test events and observable/observer
		// interactions
		String im = "/assets/mario.png";
		String im2 = "/assets/Luigi.jpg";

		myModel.getImages().addObserver(myGraphics);
		myModel.getGameObjectCollection().addObserver(myGameObjects);

		GameObject test = new GameObject(new ArrayList<Component>(), im, new Point2D.Double(), 0, 0, 0, "Mario");
		//System.out.println(test.getCurrentImageName());
		myModel.getGameObjectCollection().addGameObject(test);
		
		myModel.getImages().addImage(im);
		myModel.getImages().addImage(im2);

		TitledPane graphics = new TitledPane(myLanguage.getString("Images"),
				myGraphics);
		TitledPane sounds = new TitledPane(myLanguage.getString("Sounds"),
				mySounds);
		TitledPane gameObjects = new TitledPane(myLanguage.getString("GameObjects"),
				myGameObjects);

		leftView.getPanes().addAll(graphics, sounds, gameObjects);
		BorderPane.setAlignment(leftView, Pos.TOP_RIGHT);

		return leftView;
	}

	private TitledPane initializeRight() {
		TitledPane properties = new TitledPane(
				myLanguage.getString("Properties"), myProperties);
		properties.setCollapsible(false);
		return properties;
	}

	/**
	 * Here lie the sad, sad public methods of this controller (To be filled in
	 * when Game Engine classes are solidified and created)
	 */

	/**
	 * Sprite Methods
	 */
	public void editSprite() {

	}

	public void addSprite() {

	}

	public void removeSprite() {

	}

	public void editSpriteOnLevel() {

	}

	/**
	 * Level Methods
	 */
	public void addSpriteToLevel() {

	}

	public void removeSpriteFromLevel() {

	}

	public void addLevel() {

	}

	public void removeLevel() {

	}

	/**
	 * Condition Methods
	 */

	public void addButtonCondition() {

	}

	public void removeButtonCondition() {

	}

	public void addSpriteCondition(Condition c) {

	}

	public void removeSpriteCondition(Condition c) {

	}

	public void addAction(Condition c, Action a) {

	}

	public void removeAction(Condition c, Action a) {

	}

}
