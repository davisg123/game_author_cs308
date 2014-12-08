package authoring.view.propertiesview;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import authoring.view.icons.FileIcon;
import authoring.view.icons.ImageBasedIcon;

public class FileProperties extends Properties{

	public FileProperties(Object o) {
		initializeProperties(o);
	}

	@Override
	public void initializeProperties(Object o) {
		FileIcon file = (FileIcon) o;
		
		this.getChildren().clear();
		
		HBox imageField = new HBox();
		imageField.getChildren().add(new Text("File: "));
		imageField.getChildren().add(new TextField(file.getName()));
		this.getChildren().add(imageField);
		
		
	}

}
