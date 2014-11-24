package authoring.eventhandlers;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.model.collections.LevelsCollection;
import authoring.view.gameobjectsview.GameObjectGraphic;
import authoring.view.levelview.LevelsView;
import authoring.view.propertiesview.PropertiesView;
import engine.gameObject.GameObject;
import engine.level.Level;
import static authoring.view.levelview.SingleLevelView.OBJECT_X_OFFSET;
import static authoring.view.levelview.SingleLevelView.OBJECT_Y_OFFSET;



/**
 * Event handler for dragging graphics on the level view. Fills properties view
 * with status and allows user to drag objects to adjust the level.
 * 
 * @author Wesley Valentine
 *
 */

public class GameObjectDragHandler implements GameHandler<MouseEvent> {

	private LevelsView myLevelView;
	private LevelsCollection myLevelsCollection;
	private PropertiesView myProperties;


	public GameObjectDragHandler(LevelsView levelView, LevelsCollection data, PropertiesView props) {
		myLevelView = levelView;
		myLevelsCollection = data;
		myProperties = props;
	}

	@Override
	public void handle(MouseEvent event) {
		//System.out.println("reached");
		GameObjectGraphic g = (GameObjectGraphic) event.getSource();
		double x = event.getSceneX();
		double y = event.getSceneY();
		String id = myLevelView.getCurrentLevel().getID();
		for (Level level : myLevelsCollection) {
			if (level.getLevelID().equals(id)) {
				GameObject go = g.getGameObject();
				level.removeGameObject(go);
				
				double dragX = x + OBJECT_X_OFFSET;
				double dragY = y + OBJECT_Y_OFFSET;
				
				if(dragX < 0){
					System.out.println("off left");
					dragX = 0;
				}
				if(dragX > myLevelView.getWidth()){
					System.out.println("off right");
					dragX = myLevelView.getWidth();
				}
				if(dragY < 0){
					System.out.println("off top");
					dragY = 0;
				}
				if(dragY > myLevelView.getHeight()){
					System.out.println("off bottom");
					dragY = myLevelView.getHeight();
				}
				go.setX(x);
				go.setY(y);
				
				level.addGameObject(go);
				myProperties.makeProperties(go);
			}
		}

	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_RELEASED;
	}

}