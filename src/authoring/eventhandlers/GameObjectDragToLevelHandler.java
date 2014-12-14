package authoring.eventhandlers;

import static authoring.view.levelview.SingleLevelView.OBJECT_X_OFFSET;
import static authoring.view.levelview.SingleLevelView.OBJECT_Y_OFFSET;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.model.collections.GameObjectsCollection;
import authoring.model.collections.LevelsCollection;
import authoring.view.icons.GameObjectIcon;
import authoring.view.levelview.LevelsView;
import authoring.view.propertiesview.PropertiesView;
import authoring.view.wizards.GameObjectTypeWizard;
import authoring.view.wizards.GameObjectUniqueIDWizard;
import authoring.view.wizards.NameWizard;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.level.Level;
import errorsAndExceptions.ErrorPopUp;

/**
 * Handles user click on graphic objects. Projects graphic properties in
 * PropertiesView and/or creates copy of selected graphic on the active level.
 * 
 * @author Wesley Valentine
 * @author Chris Bernt
 * @author Kevin Li
 * @author Arjun Jain
 * @author Safkat Islam
 *
 */
public class GameObjectDragToLevelHandler implements GameHandler<MouseEvent> {
	private LevelsView myLevelView;
	private LevelsCollection myLevelsCollection;
	private PropertiesView myProps;
	private NameWizard myNameWizard;
	private GameObject myNewGameObject;
	private GameObjectsCollection myGameObjectCollection;

	public GameObjectDragToLevelHandler(LevelsView levelView,
			LevelsCollection data, PropertiesView props) {
		myLevelView = levelView;
		myLevelsCollection = data;
		myProps = props;
	}

	@Override
	public void handle(MouseEvent event) {
		GameObjectIcon g = (GameObjectIcon) event.getSource();
		double x = event.getSceneX();
		double y = event.getSceneY();
		GameObject gameObject = g.getGameObject();
		myNewGameObject = new GameObject(gameObject);
		myNewGameObject.setIdentifier(new Identifier(gameObject.getIdentifier()
				.getType(), ""));
		myNewGameObject.setX(x);
		myNewGameObject.setY(y);

		try {

			String id = myLevelView.getCurrentLevel().getID();
			for (Level level : myLevelsCollection) {
				if (level.getIdentifier().getUniqueId().equals(id)
						&& myLevelView.contains(x + OBJECT_X_OFFSET, y
								+ OBJECT_Y_OFFSET)) {

					myGameObjectCollection = level.getGameObjectsCollection();
					// prompt for identifier HERE
					myNameWizard = new GameObjectUniqueIDWizard(
							"Choose Unique ID", 230, 200,
							e -> updateName(level), myGameObjectCollection);

					// myNewGameObject.setIdentifier(new
					// Identifier(gameObject.getIdentifier().getType(),id
					// +"-"+level.getGameObjectsCollection().getSize()));

					myProps.displayProperties(myNewGameObject);
				}
			}
		} catch (NullPointerException e) {

		}

	}

	private void updateName(Level level) {
		String tryID = myNameWizard.getMap().get("name").getInformation();
		if (!myNameWizard.isDuplicated(tryID)) {
			myNewGameObject.getIdentifier().setUniqueId(((tryID)));
			level.addGameObject(myNewGameObject);
		} else {
			ErrorPopUp epu = new ErrorPopUp();
			epu.display("Need to enter unique ID", false);
		}
		myNameWizard.close();
	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_RELEASED;
	}

}