package authoring.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import authoring.eventhandlers.AddImageHandler;
import authoring.eventhandlers.AddLevelHandler;
import authoring.eventhandlers.GameObjectClickHandler;
import authoring.eventhandlers.GameObjectDragHandler;
import authoring.eventhandlers.GameObjectDragToLevelHandler;
import authoring.eventhandlers.ImagesClickHandler;
import authoring.model.AuthoringModel;
import authoring.view.AuthoringView;
import authoring.view.baseclasses.AccordionContainer;
import authoring.view.baseclasses.BPContainer;
import authoring.view.gameobjectsview.GameObjectsView;
import authoring.view.graphicsview.GraphicsTools;
import authoring.view.graphicsview.ImagesView;
import authoring.view.levelview.LevelsAccordionView;
import authoring.view.levelview.LevelOptions;
import authoring.view.levelview.LevelsView;
import authoring.view.propertiesview.PropertiesView;
import authoring.view.soundsview.SoundsView;
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
	private static final double LEFT_ACCORDION_HEIGHT_RATIO = .74;
	private static final double LEFT_ACCORDION_WIDTH_RATIO = .2;
	private static final double CENTER_HEIGHT_RATIO = .92;
	private static final double CENTER_WIDTH_RATIO = .6;
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
	private LevelOptions myLevelOptions;

	private GameObjectsView myGameObjects;

	private ImagesView myGraphics;
	private GraphicsTools myGraphicsTools;

	private SoundsView mySounds;
	private PropertiesView myProperties;
	private LevelsAccordionView myLevelsAccordionView;
	private File myGameLocation;

	public AuthoringController(AuthoringView view, AuthoringModel model,
			double width, double height, ResourceBundle language, File gameLoc) {
		myView = view;
		myModel = model;
		myWidth = width;
		myHeight = height;
		myLanguage = language;
		myGameLocation = gameLoc;
		initializeView();

	}

	/**
	 * Sets the contents of the AuthoringView - which is essentially an empty
	 * borderpane.
	 */

	private void initializeView() {
		initializeViewComponents();
		myView.setCenter(intitializeCenter());
		myView.setLeft(initializeLeft());
		myView.setRight(initializeRight());
		initializeGameHandlers();

		// Some hard-coded images used to test events and observable/observer
		// interactions
		String im = "/assets/mario.png";
		String im2 = "/assets/Luigi.jpg";

		myModel.getImages().addObserver(myGraphics);
		myModel.getGameObjectCollection().addObserver(myGameObjects);
		GameObject test = new GameObject(new ArrayList<Component>(), im, 0, 0,
				0, 0, 0, "Mario");
		myModel.getGameObjectCollection().addGameObject(test);

		myModel.getLevels().addObserver(myLevelsAccordionView);
	}

	/**
	 * Initializes all the view components that have a 1 to 1 relationship with
	 * backend data components. Provides event handlers for View objects to
	 * handle sending data to the backend
	 */

	private void initializeViewComponents() {
		myProperties = new PropertiesView(myLanguage, myWidth, myHeight);
		myLevels = new LevelsView(myLanguage, myWidth, myHeight);
		myLevelOptions = new LevelOptions(myLanguage, myWidth, myHeight);
		mySounds = new SoundsView(myLanguage, myWidth, myHeight);

		myGraphics = new ImagesView(myLanguage, myWidth, myHeight,
				myGameLocation);
		myGraphicsTools = new GraphicsTools(myLanguage, myWidth, myHeight);

		myGameObjects = new GameObjectsView(myLanguage, myWidth, myHeight);
		myLevelsAccordionView = new LevelsAccordionView(myLanguage, myWidth,
				myHeight);

	}

	private void initializeGameHandlers() {
		myGraphics.setEvents(new ImagesClickHandler(myProperties));
		myGameObjects
				.setEvents(
						new GameObjectClickHandler(myProperties),
						new GameObjectDragToLevelHandler(myLevels, myModel
								.getLevels()));
		myLevelOptions.setButtonBehavior(new AddLevelHandler(myModel
				.getLevels(), myLevels));
		myGraphicsTools.setButtonBehavior(new AddImageHandler(myModel
				.getImages(), myGameLocation));
		myLevels.setEventHandlers(new GameObjectClickHandler(myProperties),
				new GameObjectDragHandler(myLevels, myModel.getLevels()));
	}

	/**
	 * Initializes what goes on the left side of the borderpane.
	 * 
	 * @return AccordianView a node.
	 */
	private BorderPane intitializeCenter() {
		BPContainer center = new BPContainer(myWidth * CENTER_WIDTH_RATIO,
				myHeight * CENTER_HEIGHT_RATIO);
		center.setTop(myLevelOptions);
		center.setCenter(myLevels);
		return center;

	}

	private AccordionContainer initializeLeft() {
		AccordionContainer leftView = new AccordionContainer(myWidth, myHeight);

		BPContainer graphicsBP = new BPContainer(myWidth
				* LEFT_ACCORDION_WIDTH_RATIO, myHeight
				* LEFT_ACCORDION_HEIGHT_RATIO);
		graphicsBP.setTop(myGraphicsTools);
		graphicsBP.setCenter(myGraphics);

		TitledPane graphics = new TitledPane(myLanguage.getString("Images"),
				graphicsBP);
		TitledPane sounds = new TitledPane(myLanguage.getString("Sounds"),
				mySounds);
		TitledPane gameObjects = new TitledPane(
				myLanguage.getString("GameObjects"), myGameObjects);
		TitledPane levels = new TitledPane(myLanguage.getString("Levels"),
				myLevelsAccordionView);

		leftView.getPanes().addAll(graphics, sounds, gameObjects, levels);
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
