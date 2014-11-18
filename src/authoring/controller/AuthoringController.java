package authoring.controller;

import java.util.ResourceBundle;

import engine.actions.Action;
import engine.conditions.Condition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import authoring.model.AuthoringModel;
import authoring.view.AuthoringView;
import authoring.view.baseclasses.AccordianView;
import authoring.view.graphicsview.GraphicsView;
import authoring.view.levelview.LevelsView;
import authoring.view.levelview.SingleLevelView;
import authoring.view.soundsview.SoundsView;
import authoring.view.spritesview.SpritesView;

/**
 * Controller class that interacts between model and view. Holds and constructs
 * all the view components in order to allow communication between them.
 * 
 * @author Kevin Li
 *
 */
public class AuthoringController {
	private AuthoringView myView;
	private AuthoringModel myModel;
	private ResourceBundle myLanguage;

	private LevelsView myLevels;
	private SpritesView mySprites;
	private GraphicsView myGraphics;
	private SoundsView mySounds;
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
	 * backend data components.
	 */

	private void initializeViewComponents() {
		myLevels = new LevelsView(myLanguage, myWidth, myHeight);
		mySounds = new SoundsView(myLanguage, myWidth, myHeight);
		myGraphics = new GraphicsView(myLanguage, myWidth, myHeight);
		mySprites = new SpritesView(myLanguage, myWidth, myHeight);

	}

	/**
	 * Initializes what goes on the left side of the borderpane.
	 * 
	 * @return AccordianView a node.
	 */

	private AccordianView initializeLeft() {
		AccordianView leftView = new AccordianView(myWidth, myHeight);
		TitledPane graphics = new TitledPane(myLanguage.getString("Graphics"),
				myGraphics);
		TitledPane sounds = new TitledPane(myLanguage.getString("Sounds"),
				mySounds);

		leftView.getPanes().addAll(graphics, sounds);
		BorderPane.setAlignment(leftView, Pos.TOP_RIGHT);
		return leftView;
	}

	/**
	 * Initializes what goes on the right of the borderpane.
	 * 
	 * @return AccordianView a node.
	 */

	private AccordianView initializeRight() {
		AccordianView rightView = new AccordianView(myWidth, myHeight);
		TitledPane sprites = new TitledPane(myLanguage.getString("Sprites"),
				mySprites);

		rightView.getPanes().addAll(sprites);
		return rightView;
	}

	/**
	 * Here lie the sad, sad public methods of this controller
	 */
	
	/**
	 * Sprite Methods
	 */
	public void editSprite(){
		
	}
	
	public void addSprite(){
		
	}
	
	public void removeSprite(){
		
	}
	
	public void editSpriteOnLevel(){
		
	}
	
	/**
	 * Level Methods
	 */
	public void addSpriteToLevel(){
		
	}
	
	public void removeSpriteFromLevel(){
		
	}
	
	public void addLevel(){
		
	}
	
	public void removeLevel(){
		
	}

	/**
	 * Condition Methods
	 */
	
	public void addButtonCondition(){
		
	}
	
	public void removeButtonCondition(){
		
	}
	
	public void addSpriteCondition(Condition c){
		
	}
	
	public void removeSpriteCondition(Condition c){
		
	}
	
	public void addAction(Condition c, Action a){
		
	}
	
	public void removeAction(Condition c, Action a){
		
	}
	
}
