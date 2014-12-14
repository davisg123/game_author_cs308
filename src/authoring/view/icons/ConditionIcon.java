package authoring.view.icons;

import authoring.eventhandlers.AddActionHandler;
import authoring.eventhandlers.GameHandler;
import authoring.view.propertiesview.ConditionProperties;
import authoring.view.propertiesview.Properties;
import engine.conditions.Condition;

/**
 * @author Kevin Li
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Arjun Jain
 */
public class ConditionIcon extends TextIcon implements IPropertiesMaker {

	private Condition myCondition;

	public ConditionIcon(String label, Condition condition,
			GameHandler... handler) {
		super(label, handler);
		myCondition = condition;
	}

	public Condition getCondition() {
		return myCondition;
	}

	@Override
	public Properties makeProperties() {
		return new ConditionProperties(this, new AddActionHandler());
	}
}
