package authoring.view.wizards;

import engine.gameObject.GameObject;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import authoring.model.collections.GameObjectsCollection;

/**
 * @author Kevin Li
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Arjun Jain
 */
public class GameObjectUniqueIDWizard extends NameWizard {

	public GameObjectUniqueIDWizard(String title, double width, double height,
			EventHandler<ActionEvent> event, GameObjectsCollection col) {
		super(title, width, height, event, col);
	}

	@Override
	protected String getIdentifierComponent(GameObject g) {
		return g.getIdentifier().getUniqueId();
	}

}
