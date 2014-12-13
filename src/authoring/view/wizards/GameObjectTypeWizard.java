package authoring.view.wizards;

import engine.gameObject.GameObject;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import authoring.model.collections.GameObjectsCollection;

public class GameObjectTypeWizard extends NameWizard{
	public GameObjectTypeWizard(String title, double width,
			double height, EventHandler<ActionEvent> event,
			GameObjectsCollection col) {
		super(title, width, height, event, col);
	}

	@Override
	protected String getIdentifierComponent(GameObject g) {
		return g.getIdentifier().getType();
	}

}
