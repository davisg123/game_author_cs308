package authoring.view.propertiesview;

import authoring.view.baseclasses.ScrollView;
import authoring.view.graphicsview.GraphicsView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class SpriteProperties extends Properties{

	public SpriteProperties(ScrollView v) {
		super(v);
	}

	@Override
	public void initializeProperties(ScrollView v) {
		this.getChildren().clear();
		
		HBox imageField = new HBox();
		imageField.getChildren().add(new Text("Image: "));
		imageField.getChildren().add(new TextField(((GraphicsView) v).getMyName()));
		this.getChildren().add(imageField);
		
		HBox xField = new HBox();
		xField.getChildren().add(new Text("X: "));
		xField.getChildren().add(new TextField());
		this.getChildren().add(xField);
		
	}
	
}
