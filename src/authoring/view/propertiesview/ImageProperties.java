package authoring.view.propertiesview;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import authoring.eventhandlers.GameHandler;
import authoring.view.icons.BaseIcon;
import authoring.view.icons.ImageBasedIcon;
import authoring.view.icons.ImageIcon;

public class ImageProperties extends Properties{

	public ImageProperties(ImageIcon i, GameHandler ...handler) {
		initializeProperties(i);
	}

	@Override
	public void initializeProperties(BaseIcon i) {
		ImageBasedIcon graphic = (ImageBasedIcon) i;
		
		this.getChildren().clear();
		
		HBox imageField = new HBox();
		imageField.getChildren().add(new Text("Image: "));
		imageField.getChildren().add(new TextField(graphic.getName()));
		this.getChildren().add(imageField);
		
		
	}

}
