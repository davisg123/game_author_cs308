package authoring.view.conditionsview;

import java.util.ResourceBundle;

import javafx.scene.layout.VBox;
import authoring.eventhandlers.GameHandler;
import authoring.view.baseclasses.ScrollView;
import authoring.view.icons.ConditionIcon;
import data.Observable;
import data.Observer;
import engine.conditions.Condition;

public class ConditionsAccordionView extends ScrollView implements Observer {
	private static final double VIEW_HEIGHT_RATIO = .74;
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
		addCondition((Condition) arg, myEvents);
	}

	public void setGraphicEvents(GameHandler... gameHandlers) {
		myEvents = gameHandlers;
	}

	public void addCondition(Condition condition, GameHandler ...gameHandlers) {
		ConditionIcon icon = new ConditionIcon(condition.getIdentifier().getUniqueId(), condition, gameHandlers);
		myVbox.getChildren().add(icon);
	}

}
