package authoring.view.propertiesview;

import engine.gameObject.GameObject;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import authoring.view.graphicsview.Graphic;

public class GameObejctsProperties extends Properties{

	public GameObejctsProperties(GameObject gObj) {
		super(gObj);
	}

	@Override
	public void initializeProperties(Object g) {
		
		GameObject gameObject = (GameObject) g; 
		
		this.getChildren().clear();
		
		HBox imageField = new HBox();
		imageField.getChildren().add(new Text("Image: "));
		imageField.getChildren().add(new TextField(gameObject.getCurrentImageName()));
		this.getChildren().add(imageField);
		
//		HBox xField = new HBox();
//		xField.getChildren().add(new Text("X: "));
//		xField.getChildren().add(new TextField(Double.toString(gameObject.getPosition().getX())));
//		this.getChildren().add(xField);
//		
//		HBox yField = new HBox();
//		yField.getChildren().add(new Text("Y: "));
//		yField.getChildren().add(new TextField(Double.toString(gameObject.getPosition().getY())));
//		this.getChildren().add(yField);

		HBox widthField = new HBox();
		widthField.getChildren().add(new Text("Width: "));
		widthField.getChildren().add(new TextField(Double.toString(gameObject.getWidth())));
		this.getChildren().add(widthField);
		
		HBox heightField = new HBox();
		heightField.getChildren().add(new Text("Height: "));
		heightField.getChildren().add(new TextField(Double.toString(gameObject.getHeight())));
		this.getChildren().add(heightField);
		
		
		
		HBox visibilityField = new HBox();
		CheckBox cb = new CheckBox("Enabled");
		cb.setSelected(gameObject.isEnabled());
		visibilityField.getChildren().add(cb);
		this.getChildren().add(visibilityField);
		
		Button submit = new Button("Submit");
		submit.setOnMouseClicked(event -> submit());
		this.getChildren().add(submit);

	}
	
	public void submit(){
		
	}
	
}
