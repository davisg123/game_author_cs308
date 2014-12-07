package authoring.view.propertiesview;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import authoring.view.graphicsview.Graphic;
import authoring.view.graphicsview.ImageGraphic;

public class ImageProperties extends Properties{

	public ImageProperties(Graphic g) {
		initializeProperties(g);
	}

	@Override
	public void initializeProperties(Graphic g) {
		Graphic graphic = (ImageGraphic) g;
		
		this.getChildren().clear();
		
		HBox imageField = new HBox();
		imageField.getChildren().add(new Text("Image: "));
		imageField.getChildren().add(new TextField(graphic.getName()));
		this.getChildren().add(imageField);
		
		
	}

}
