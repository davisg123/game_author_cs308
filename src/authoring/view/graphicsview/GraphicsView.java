package authoring.view.graphicsview;

import java.io.File;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import authoring.eventhandlers.AddImageHandler;
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
public class GraphicsView extends ScrollView implements Observer {
	private static final double VIEW_HEIGHT_RATIO = .95;
	private static final double VIEW_WIDTH_RATIO = 0.2;
	private VBox myVbox = new VBox();
	private GameHandler[] myOnClick;
	private File myGameLocation;

	public GraphicsView(ResourceBundle language, double width, double height,
			File gameLoc) {
		super(language, width, height);
		setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
		this.setContent(myVbox);
		myGameLocation = gameLoc;
	}

	public void setEvents(GameHandler... action) {
		myOnClick = action;
	}

	@Override
	public void update(Observable o, Object arg) {
		addImage((String) arg);
	}

	public void addImage(String s) {
		Graphic graphic = new Graphic(s, myOnClick);
		graphic.makeGraphic(myGameLocation);
		myVbox.getChildren().add(graphic);

	}

	public void setButton(AddImageHandler addImageHandler) {
		// TODO Auto-generated method stub
		myVbox.getChildren().add(new Text("Indent"));
		myVbox.getChildren().add(new Text("Indent"));
		myVbox.getChildren().add(new Text("Indent"));
		myVbox.getChildren().add(new Text("Indent"));
		myVbox.getChildren().add(new Text("Indent"));
		myVbox.getChildren().add(new Text("Indent"));
		myVbox.getChildren().add(new Text("Indent"));
		Button add = new Button("Add");
		add.addEventFilter(addImageHandler.getEventType(), addImageHandler);
		myVbox.getChildren().add(add);

	}
}
