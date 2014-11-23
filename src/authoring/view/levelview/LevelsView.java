package authoring.view.levelview;

import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import authoring.eventhandlers.AddLevelHandler;
import authoring.eventhandlers.GameHandler;
import authoring.view.baseclasses.BPContainer;
import authoring.view.baseclasses.TabView;
import authoring.view.gameobjectsview.GameObjectGraphic;
import authoring.view.graphicsview.Graphic;

/**
 * View class that contains all the levels in the program. Corresponds with
 * backend model data - LevelsCollection. Updates if any changes occur via
 * observer/observable.
 * 
 * @author Kevin Li
 * @author Wesley Valentine
 *
 */
public class LevelsView extends TabView implements Observer {
	private static final double VIEW_HEIGHT_RATIO = .92;
	private static final double VIEW_WIDTH_RATIO = 0.6;
	private GameHandler[] myEvents;

	public LevelsView(ResourceBundle language, double width, double height) {
		super(language, width, height);
		super.setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

	/**
	 * Creates a copy of a passed in Graphic and adds it to the current level.
	 * Passes in Event Handler to the Graphic, handling drag events.
	 * 
	 * @param graphic
	 * @param x
	 * @param y
	 * @param handler
	 */

	// PROBABLY NEEDS TO BE REMOVED
	// public void addGameObjectToView(GameObjectGraphic graphic, double x,
	// double y,
	// GameHandler ... handler) {
	// System.out.println("called");
	// Graphic g = new GameObjectGraphic(graphic.getGameObject(),handler);
	// g.makeGraphic();
	// g.setLayoutX(x - 230);
	// g.setLayoutY(y - 100);
	// SingleLevelView currentLevelView = (SingleLevelView) myLevelTabs
	// .getSelectionModel().getSelectedItem().getContent();
	// currentLevelView.getChildren().add(g);
	//
	// }

	public SingleLevelView getCurrentLevel() {
		return (SingleLevelView) this.getSelectionModel().getSelectedItem()
				.getContent();
	}

	/**
	 * Moves Sprite to new location on level view.
	 * 
	 * @param g
	 * @param x
	 * @param y
	 */
	public void moveSpriteOnLevel(Graphic g, double x, double y) {
		g.setLayoutX(x - 230);
		g.setLayoutY(y - 100);
	}
	public SingleLevelView addNewLevel(String myLevelID) {
		Tab tab = new Tab(myLevelID);
		SingleLevelView newView = new SingleLevelView(myWidth, myHeight,
				myEvents);
		tab.setContent(newView);
		this.getTabs().add(tab);
		this.getSelectionModel().select(tab);
		return newView;

	}

	public void setEventHandlers(GameHandler... handlers) {
		myEvents = handlers;
	}
}
