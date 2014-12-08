package authoring.view.wizards;

import javafx.scene.control.RadioButton;
import engine.conditions.Condition;

public class ConditionRadioButton extends RadioButton{
	
	private Condition myCondition;
	
	public ConditionRadioButton(String name, Condition cond){
		this.setText(name);
		myCondition = cond;
	}
	
	public Condition getCondition(){
		return myCondition;
	}
}
