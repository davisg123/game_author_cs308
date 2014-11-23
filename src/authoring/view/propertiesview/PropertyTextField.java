package authoring.view.propertiesview;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class PropertyTextField extends HBox{
	
	private TextField myField;
	
	public PropertyTextField(String name, String information){
		this.getChildren().add(new Text(name));
		TextField field = new TextField(information);
		myField = field;
		this.getChildren().add(field);
	}
	
	public String getInformation(){
		return myField.getText();
	}
}
