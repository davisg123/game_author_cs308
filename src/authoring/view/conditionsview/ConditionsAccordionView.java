package authoring.view.conditionsview;

import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.scene.layout.VBox;
import authoring.eventhandlers.GameHandler;
import authoring.view.baseclasses.ScrollView;

public class ConditionsAccordionView extends ScrollView implements Observer {
	private static final double VIEW_HEIGHT_RATIO = .74;
	private static final double VIEW_WIDTH_RATIO = 0.2;
	private VBox myVbox = new VBox();	
	private GameHandler[] myEvents;
	private GameHandler[] levelEvents;
	private String myName;
	public ConditionsAccordionView(ResourceBundle language, double width,
			double height) {
		super(language, width, height);
		setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
		this.setContent(myVbox);
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	public void setEvents(GameHandler ... gameHandlers){
		myEvents = gameHandlers;
	}
	
	public void addCondition(){
		
	}

}
