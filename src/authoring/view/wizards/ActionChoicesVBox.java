package authoring.view.wizards;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class ActionChoicesVBox extends VBox{
	
	private ToggleGroup myToggleGroup;
	
	public ActionChoicesVBox(){
		initializeGroup();
	}
	
	public void initializeGroup(){
		
		myToggleGroup = new ToggleGroup();
		
		RadioButton[] radioButtons = {
				new RadioButton("ChangeLevelAction"),
				new RadioButton("TranslateTypeAction")
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
