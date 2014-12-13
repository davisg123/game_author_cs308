package authoring.view.wizards;

import java.util.ResourceBundle;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class ActionChoicesVBox extends VBox{
	
	private ToggleGroup myToggleGroup;
	public static final ResourceBundle ACTIONS_PARAMETERS = ResourceBundle.getBundle("assets.actionsParameters");

	
	public ActionChoicesVBox(){
		initializeGroup();
	}
	
	public void initializeGroup(){
		
		myToggleGroup = new ToggleGroup();
		
		for(String s : ACTIONS_PARAMETERS.keySet()){
			RadioButton rb = new RadioButton(s);
			rb.setToggleGroup(myToggleGroup);
			this.getChildren().add(rb);
		}
		
		
	}
	
	public String getSelected(){
		return ((RadioButton) myToggleGroup.getSelectedToggle()).getText();
	}

}
