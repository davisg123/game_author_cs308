package authoring;

import javafx.scene.control.Button;

public abstract class VoogaButton extends Button{
	
	public VoogaButton(){
		this.setOnAction(event -> action());
	}
	
	public abstract void action();

	
}
