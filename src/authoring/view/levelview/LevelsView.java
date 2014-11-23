package authoring.view.levelview;

import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.scene.control.TabPane;
import authoring.eventhandlers.AddLevelHandler;
import authoring.eventhandlers.GameHandler;
import authoring.view.baseclasses.BPView;
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
public class LevelsView extends BPView implements Observer {
	private static final double VIEW_HEIGHT_RATIO = .92;
	private static final double VIEW_WIDTH_RATIO = 0.6;
	private LevelOptions myLevelOptions;
	private TabPane myLevelTabs;

	public LevelsView(ResourceBundle language, double width, double height) {
		super(language, width, height);
		myLevelTabs = new TabPane();
		myLevelOptions = new LevelOptions(language, myLevelTabs, width, height);
		super.setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
		this.setTop(myLevelOptions);
		this.setCenter(myLevelTabs);
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
	
	//PROBABLY NEEDS TO BE REMOVED
//	public void addGameObjectToView(GameObjectGraphic graphic, double x, double y,
//			GameHandler ... handler) {
//		System.out.println("called");
//		Graphic g = new GameObjectGraphic(graphic.getGameObject(),handler);
//		g.makeGraphic();
//		g.setLayoutX(x - 230);
//		g.setLayoutY(y - 100);
//		SingleLevelView currentLevelView = (SingleLevelView) myLevelTabs
//				.getSelectionModel().getSelectedItem().getContent();
//		currentLevelView.getChildren().add(g);
//
//	}
	
	public SingleLevelView getCurrentLevel(){
		return (SingleLevelView) myLevelTabs.getSelectionModel().getSelectedItem().getContent();
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
	
	public LevelOptions getLevelOptions(){
		return myLevelOptions;
	}

}
