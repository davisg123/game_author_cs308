package authoring.view.graphicsview;

import java.io.File;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.scene.layout.VBox;
import authoring.eventhandlers.GameHandler;
import authoring.view.baseclasses.ScrollView;

/**
 * View component that corresponds with the backend model component -
 * GraphicsCollection. Updates if any changes occur in Graphics Collection via
 * observer/observable.
 * 
 * @author Kevin Li
 * @author Chris Bernt
 *
 */
public class ImagesView extends ScrollView implements Observer {
	private static final double VIEW_HEIGHT_RATIO = .69;
	private static final double VIEW_WIDTH_RATIO = 0.2;
	private VBox myVbox = new VBox();
	private GameHandler[] myEvents;
	private File myGameLocation;
	private String myName;

	public ImagesView(ResourceBundle language, double width, double height,
			File gameLoc) {
		super(language, width, height);
		setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
		this.setContent(myVbox);
		myGameLocation = gameLoc;
	}

	@Override
	public void update(Observable o, Object arg) {
		addImage((String) arg);
	}

	public void setEvents(GameHandler... gameHandlers) {
		myEvents = gameHandlers;
	}

	public void addImage(String s) {
		Graphic graphic = new Graphic(s, myEvents);
		graphic.makeGraphic(myGameLocation);
		myName = s;
		myVbox.getChildren().add(graphic);
	}

	public String getMyName() {
		return myName;
	}

}
