package authoring.view.wizards;

import java.util.ResourceBundle;
import java.util.TreeSet;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class ConditionChoicesVBox extends VBox{
	
	private ToggleGroup myToggleGroup;
	public static final ResourceBundle CONDITIONS_PARAMETERS = ResourceBundle.getBundle("assets.conditionsParameters");
	
	public ConditionChoicesVBox(){
		initializeGroup();
	}
	
	public void initializeGroup(){
		
		myToggleGroup = new ToggleGroup();

		
		for(String s : CONDITIONS_PARAMETERS.keySet()){
			RadioButton rb = new RadioButton(s);
			rb.setToggleGroup(myToggleGroup);
			this.getChildren().add(rb);
		}
		
	}
	
	public String getSelected(){
		return ((RadioButton) myToggleGroup.getSelectedToggle()).getText();
	}
}
