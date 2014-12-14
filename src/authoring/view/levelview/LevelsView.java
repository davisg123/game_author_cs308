package authoring.view.levelview;

import java.io.File;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import engine.level.Level;
import javafx.scene.control.Tab;
import authoring.eventhandlers.GameHandler;
import authoring.view.baseclasses.TabView;
import authoring.view.icons.ImageBasedIcon;

/**
 * View class that contains all the levels in the program. Corresponds with
 * backend model data - LevelsCollection. Updates if any changes occur via
 * observer/observable.
 * 
 * @author Kevin Li
 * @author Wesley Valentine
 * @author Chris Bernt
 * @author Arjun Jain
 */
public class LevelsView extends TabView implements Observer {
	private static final double VIEW_HEIGHT_RATIO = .87;
	private static final double VIEW_WIDTH_RATIO = 0.6;
	private File myGameLocation;
	private GameHandler[] myEvents;

	public LevelsView(ResourceBundle language, double width, double height,
			File gameLoc) {
		super(language, width, height);
		super.setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
		myGameLocation = gameLoc;
	}

	@Override
	public void update(Observable o, Object arg) {

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
	public void moveSpriteOnLevel(ImageBasedIcon g, double x, double y) {
		g.setLayoutX(x - 230);
		g.setLayoutY(y - 100);
	}

	public SingleLevelView addNewLevel(String myLevelID, String bgImage) {
		Tab tab = new Tab(myLevelID);
		SingleLevelView newView = new SingleLevelView(myGameLocation, myWidth,
				myHeight, bgImage, myEvents);
		tab.setContent(newView);
		this.getTabs().add(tab);
		this.getSelectionModel().select(tab);
		return newView;
	}

	/**
	 * THIS IS REPEATED CODE WE NEED TO FIX
	 * 
	 * @param l
	 * @return
	 */
	public SingleLevelView addExistingLevel(Level l, GameHandler... events) {
		Tab tab = new Tab(l.getIdentifier().getUniqueId());
		SingleLevelView newView = new SingleLevelView(myGameLocation, myWidth,
				myHeight, l, events);
		// System.out.println(events.length);
		newView.setPaneSize(l.getWidth(), l.getHeight());
		tab.setContent(newView);
		this.getTabs().add(tab);
		this.getSelectionModel().select(tab);
		return newView;
	}

	public boolean levelOpenInTabs(String id) {

		for (Tab tab : this.getTabs()) {
			if (((SingleLevelView) tab.getContent()).getID().equals(id)) {
				this.getSelectionModel().select(tab);
				return true;
			}
		}
		return false;
	}

	public void setEventHandlers(GameHandler... handlers) {
		myEvents = handlers;
	}
}
