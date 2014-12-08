package authoring.view.propertiesview;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import authoring.view.icons.ConditionIcon;

public class ConditionProperties extends Properties{

	//will refactor pl0X
	public ConditionProperties(Object o) {
		initializeProperties(o);
	}

	@Override
	public void initializeProperties(Object o) {
		ConditionIcon icon = (ConditionIcon) o;
		
		this.getChildren().clear();
		
		HBox imageField = new HBox();
		imageField.getChildren().add(new Text("Name: "));
		imageField.getChildren().add(new TextField(icon.getName()));
		this.getChildren().add(imageField);
		
		
	}
	
}
