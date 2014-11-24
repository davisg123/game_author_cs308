package authoring.eventhandlers;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.model.collections.LevelsCollection;
import authoring.view.gameobjectsview.GameObjectGraphic;
import authoring.view.levelview.LevelsView;
import authoring.view.propertiesview.PropertiesView;
import engine.gameObject.GameObject;
import engine.level.Level;

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
				if(!myLevelView.contains(x-230, y-100))
				{
					go.setX(230);
					go.setY(100);
				}
				else
				{
					go.setX(x);
					go.setY(y);
				}
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