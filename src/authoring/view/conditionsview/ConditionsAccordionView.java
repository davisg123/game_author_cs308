package authoring.view.conditionsview;

import java.util.ResourceBundle;

import javafx.scene.layout.VBox;
import authoring.eventhandlers.GameHandler;
import authoring.model.collections.ConditionsCollection;
import authoring.view.baseclasses.CollectionView;
import authoring.view.icons.ConditionIcon;
import data.Observable;
import data.Observer;
import engine.conditions.Condition;

/**
 * @author Kevin Li
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Arjun Jain
 */
public class ConditionsAccordionView extends CollectionView implements Observer {
	private static final double VIEW_HEIGHT_RATIO = .65;
	private static final double VIEW_WIDTH_RATIO = 0.2;
	private VBox myVbox = new VBox();
	private GameHandler[] myEvents;
	private GameHandler[] levelEvents;
	private String myName;

	public ConditionsAccordionView(ResourceBundle language, double width,
			double height) {
		super(language, width, height);
		setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
		this.setContent(myVbox);
	}

	@Override
	public void update(Observable o, Object arg) {
		addCondition((ConditionsCollection) arg, myEvents);
	}

	public void setIconEvents(GameHandler... gameHandlers) {
		myEvents = gameHandlers;
	}

	public void addCondition(ConditionsCollection conditions,
			GameHandler... gameHandlers) {
		myVbox.getChildren().clear();
		for (Condition c : conditions) {
			ConditionIcon icon = new ConditionIcon(c.getIdentifier()
					.getUniqueId(), c, gameHandlers);
			myVbox.getChildren().add(icon);
		}
	}

}
