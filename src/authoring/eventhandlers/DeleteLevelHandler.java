package authoring.eventhandlers;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.control.Tab;
import authoring.model.collections.LevelsCollection;
import authoring.view.levelview.LevelsView;
import authoring.view.levelview.SingleLevelView;
import authoring.view.wizards.AddConditionIDWizard;
import authoring.view.wizards.Wizard;

/**
 * @author Kevin Li
 * @author Arjun Jain
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Safkat Islam
 */
public class DeleteLevelHandler implements GameHandler<Event> {

	private LevelsCollection myLevelsCollection;
	private Wizard myDeleteLevelWizard;
	private LevelsView myLevelsTabs;

	public DeleteLevelHandler(LevelsCollection collection, LevelsView lv) {
		myLevelsCollection = collection;
		myLevelsTabs = lv;
	}

	@Override
	public void handle(Event arg0) {

		myDeleteLevelWizard = new AddConditionIDWizard("Delete Level", 200,
				200, event -> deleteLevel());

	}

	@Override
	public EventType<Event> getEventType() {
		return Event.ANY;
	}

	private void deleteLevel() {
		String toRemove = myDeleteLevelWizard.getMap().get("ID")
				.getInformation();
		myLevelsCollection.removeByID(toRemove);

		for (Tab tab : myLevelsTabs.getTabs()) {
			if (((SingleLevelView) tab.getContent()).getID().equals(toRemove)) {
				myLevelsTabs.getTabs().remove(tab);
				break;
			}
		}

		myDeleteLevelWizard.close();
	}

}
