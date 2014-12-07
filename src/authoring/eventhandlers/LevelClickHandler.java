package authoring.eventhandlers;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.view.icons.LevelIcon;
import authoring.view.propertiesview.PropertiesView;

public class LevelClickHandler extends ClickHandler<LevelIcon>{

	public LevelClickHandler(PropertiesView properties) {
		super(properties);
	}

}

