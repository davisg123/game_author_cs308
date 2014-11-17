package authoring;

import javafx.scene.control.Button;

public class TestButtonController {
	
	public TestButtonController(Button button){
		button.setOnAction(event -> suckmahd());
	}
	
	private void suckmahd(){
		System.out.println("suck. mah d.");
	}
	
	
}
