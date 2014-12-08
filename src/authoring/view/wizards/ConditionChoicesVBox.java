package authoring.view.wizards;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class ConditionChoicesVBox extends VBox{
	
	private ToggleGroup myToggleGroup;
	
	public ConditionChoicesVBox(){
		initializeGroup();
	}
	
	public void initializeGroup(){
		
		myToggleGroup = new ToggleGroup();
		
		RadioButton[] radioButtons = {
				new RadioButton("ButtonCondition"),
				new RadioButton("BoundaryConditionX"),
				new RadioButton("TimeCondition")
		};
		
		
		
		
		for(RadioButton rb : radioButtons){
			rb.setToggleGroup(myToggleGroup);
			this.getChildren().add(rb);
		}
		
		
	}
	
	public String getSelected(){
		return ((RadioButton) myToggleGroup.getSelectedToggle()).getText();
	}
}
