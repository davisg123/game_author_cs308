package authoring.view.levelview;

import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import authoring.controller.AuthoringController.GraphicsDragHandler;
import authoring.view.baseclasses.BPView;
import authoring.view.graphicsview.Graphic;

/**
 * View class that contains all the levels in the program. Corresponds with
 * backend model data - LevelsCollection. Updates if any changes occur via
 * observer/observable.
 * 
 * @author Kevin Li
 *
 */
public class LevelsView extends BPView implements Observer {
	private static final double VIEW_HEIGHT_RATIO = .92;
	private static final double VIEW_WIDTH_RATIO = 0.6;
	private LevelOptions myLevelOptions;
	private TabPane myLevels;

	public LevelsView(ResourceBundle language, double width, double height) {
		super(language, width, height);
		myLevels = new TabPane();
		myLevelOptions = new LevelOptions(language, myLevels, width, height);
		super.setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);

		this.setTop(myLevelOptions);
		this.setCenter(myLevels);

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}
	
	public void addSpriteToView(Graphic graphic, double x, double y, GraphicsDragHandler handler){
		//g.makeGraphic();
		Graphic g = new Graphic(graphic.getName(), handler);
		g.makeGraphic(MouseEvent.MOUSE_DRAGGED);
		g.setLayoutX(x -230);
		g.setLayoutY(y - 100);
		SingleLevelView v = (SingleLevelView) myLevels.getSelectionModel().getSelectedItem().getContent();
		v.getChildren().add(g);
		//this.getChildren().add(g);
		
		
	}
	public void moveSpriteOnLevel(Graphic g, double x, double y){
		//g.makeGraphic();
		g.setLayoutX(x-230);
		g.setLayoutY(y-100);
		
	}
	
}
