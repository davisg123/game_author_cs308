package authoring.eventhandlers;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.view.icons.ImageIcon;
import authoring.view.propertiesview.PropertiesView;

public class ImagesClickHandler extends ClickHandler<ImageIcon>{

	public ImagesClickHandler(PropertiesView properties) {
		super(properties);
	}

}
