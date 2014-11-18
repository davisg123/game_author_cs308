package authoring.view.graphicsview;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Graphic {
	
	private String myName;
	private EventHandler<MouseEvent> myOnClick;
	
	public Graphic(String s, EventHandler<MouseEvent> eh){
		myName = s;
		myOnClick = eh;
	}
	
	public VBox makeGraphic(){
		VBox imageBox = new VBox();
		Image image = new Image(getClass().getResourceAsStream(myName));
		ImageView im = new ImageView(image);
		im.setFitHeight(100);
		im.setFitWidth(100);
		imageBox.getChildren().add(im);
		imageBox.getChildren().add(new Text(myName));
		
		imageBox.setOnMouseClicked(myOnClick);
		
		return imageBox;
	}
	
}
