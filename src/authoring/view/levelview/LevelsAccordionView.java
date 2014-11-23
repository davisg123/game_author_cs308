package authoring.view.levelview;

import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import authoring.eventhandlers.GameHandler;
import authoring.model.collections.LevelsCollection;
import authoring.view.baseclasses.ScrollView;
import engine.level.Level;

public class LevelsAccordionView extends ScrollView implements Observer{
	private static final double VIEW_HEIGHT_RATIO = .95;
	private static final double VIEW_WIDTH_RATIO = 0.2;
	private VBox myVbox = new VBox();	
	private GameHandler[] myEvents;
	private String myName;
	
	public LevelsAccordionView(ResourceBundle language, double width,
			double height) {
		super(language, width, height);
		setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
		this.setContent(myVbox);
	}

	@Override
	public void update(Observable o, Object arg) {
		addLevel((Level) arg, myEvents);
		
	}
	
	public void setEvents(GameHandler ... gameHandlers){
		myEvents = gameHandlers;
	}
	
	public void addLevel(Level l, GameHandler ... handler){
		myName = l.getLevelID();
		myVbox.getChildren().add(new Text(myName));
	}
	
	public String getMyName(){
		return myName;
	}
}
