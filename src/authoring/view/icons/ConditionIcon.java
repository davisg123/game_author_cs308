package authoring.view.icons;

import static authoring.view.icons.LevelIcon.DEFAULT_FONT_SIZE;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import authoring.eventhandlers.AddActionHandler;
import authoring.eventhandlers.GameHandler;
import authoring.view.propertiesview.ConditionProperties;
import authoring.view.propertiesview.Properties;
import engine.conditions.Condition;

public class ConditionIcon extends BaseIcon implements IPropertiesMaker{

	private Condition myCondition;
	private GameHandler[] myEvents;
	
	public ConditionIcon(String label, Condition condition, GameHandler[] handler) {
		super(label, handler);
		myCondition = condition;
		myEvents = handler;
		setupGraphic();
	}
	
	//SAME AS LEVEL ICON, REFACTOR
	public void setupGraphic(){
		Text text = new Text(myLabel);
		text.setFont(new Font(DEFAULT_FONT_SIZE));
		this.getChildren().add(text);
		for (GameHandler g : myOnClick) {
			this.addEventFilter(g.getEventType(), g);
		}
	}

	public Condition getCondition(){
		return myCondition;
	}

	@Override
	public Properties makeProperties() {
		return new ConditionProperties(this, new AddActionHandler());
	}
}
