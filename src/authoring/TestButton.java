package authoring;

import javafx.scene.control.Button;

public class TestButton extends Button {
	
	public TestButton(){
		this.setOnAction(event -> printered());
	}
	
	public void printered(){
		System.out.println("herp derp");
	}
}
