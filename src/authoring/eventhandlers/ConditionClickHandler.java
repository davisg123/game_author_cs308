package authoring.eventhandlers;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.view.icons.ConditionIcon;
import authoring.view.propertiesview.PropertiesView;

public class ConditionClickHandler implements GameHandler<MouseEvent>{
	
	private PropertiesView myProperties;
	
	public ConditionClickHandler(PropertiesView props){
		myProperties = props;
	}
	
	@Override
	public void handle(MouseEvent event) {
		ConditionIcon condition = (ConditionIcon) event.getSource();
		myProperties.makeProperties(condition);
		
	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_PRESSED;
	}

}

