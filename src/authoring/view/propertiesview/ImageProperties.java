package authoring.view.propertiesview;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import authoring.view.graphicsview.Graphic;

public class ImageProperties extends Properties{

	public ImageProperties(Object o) {
		initializeProperties(o);
	}

	@Override
	public void initializeProperties(Object o) {
		Graphic graphic = (Graphic) o;
		
		this.getChildren().clear();
		
		HBox imageField = new HBox();
		imageField.getChildren().add(new Text("Image: "));
		imageField.getChildren().add(new TextField(graphic.getName()));
		this.getChildren().add(imageField);
		
		
	}

}
