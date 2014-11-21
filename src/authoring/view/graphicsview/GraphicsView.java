package authoring.view.graphicsview;

import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import authoring.view.baseclasses.ScrollView;

/**
 * View component that corresponds with the backend model component -
 * GraphicsCollection. Updates if any changes occur in Graphics Collection via
 * observer/observable.
 * 
 * @author Kevin Li
 *
 */
public class GraphicsView extends ScrollView implements Observer {
	private static final double VIEW_HEIGHT_RATIO = .95;
	private static final double VIEW_WIDTH_RATIO = 0.2;
	private VBox myVbox = new VBox();	
	private EventHandler<MouseEvent> myOnClick;
	private String myName;
	
	public GraphicsView(ResourceBundle language, double width, double height, EventHandler<MouseEvent> action) {
		super(language, width, height);
		setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
		this.setContent(myVbox);
		myOnClick = action;
	}

	@Override
	public void update(Observable o, Object arg) {
		addImage((String) arg, myOnClick);
	}
	
	public void addImage(String s, EventHandler<MouseEvent> handler){
		Graphic graphic = new Graphic(s, handler);
		graphic.makeGraphic(MouseEvent.MOUSE_RELEASED);
		myName = s;
		myVbox.getChildren().add(graphic);
		
	}
	
	public String getMyName(){
		return myName;
	}

}
