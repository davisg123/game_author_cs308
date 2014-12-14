package authoring.view.wizards;

import javafx.scene.control.RadioButton;
import engine.conditions.Condition;

/**
 * @author Kevin Li
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Arjun Jain
 */
public class ConditionRadioButton extends RadioButton {

	private Condition myCondition;

	public ConditionRadioButton(String name, Condition cond) {
		this.setText(name);
		myCondition = cond;
	}

	public Condition getCondition() {
		return myCondition;
	}
}
