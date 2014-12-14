package authoring.view.icons;

import static authoring.view.icons.LevelIcon.DEFAULT_FONT_SIZE;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import authoring.eventhandlers.AddActionHandler;
import authoring.eventhandlers.GameHandler;
import authoring.view.propertiesview.ConditionProperties;
import authoring.view.propertiesview.Properties;
import engine.conditions.Condition;

public class ConditionIcon extends TextIcon implements IPropertiesMaker{

	private Condition myCondition;
	
	public ConditionIcon(String label, Condition condition, GameHandler... handler) {
		super(label, handler);
		myCondition = condition;
	}
	
	public Condition getCondition(){
		return myCondition;
	}

	@Override
	public Properties makeProperties() {
		return new ConditionProperties(this, new AddActionHandler());
	}
}
