package authoring.view.propertiesview;

import authoring.view.baseclasses.ScrollView;
import authoring.view.graphicsview.Graphic;
import authoring.view.graphicsview.GraphicsView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class SpriteProperties extends Properties{

	public SpriteProperties(Graphic g) {
		super(g);
	}

	@Override
	public void initializeProperties(Graphic g) {
		this.getChildren().clear();
		
		HBox imageField = new HBox();
		imageField.getChildren().add(new Text("Image: "));
		imageField.getChildren().add(new TextField(g.getName()));
		this.getChildren().add(imageField);
		
		HBox xField = new HBox();
		xField.getChildren().add(new Text("X: "));
		xField.getChildren().add(new TextField());
		this.getChildren().add(xField);
		
	}
	
}
