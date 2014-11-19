package authoring.view.graphicsview;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Graphic extends VBox{
	
	private String myName;
	private EventHandler<MouseEvent> myOnClick;
	
	public Graphic(String s, EventHandler<MouseEvent> eh){
		myName = s;
		myOnClick = eh;
	}
	
	public void makeGraphic(){
		Image image = new Image(getClass().getResourceAsStream(myName));
		ImageView im = new ImageView(image);
		im.setFitHeight(100);
		im.setFitWidth(100);
		this.getChildren().add(im);
		this.getChildren().add(new Text(myName));
		
		this.setOnMouseClicked(myOnClick);

	}
	
	public String getName(){
		return myName;
	}
	
}
