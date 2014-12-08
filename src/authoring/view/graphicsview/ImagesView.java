package authoring.view.graphicsview;

import java.io.File;
import java.util.ResourceBundle;

import data.Observable;
import data.Observer;
import javafx.scene.layout.VBox;
import authoring.eventhandlers.GameHandler;
import authoring.view.baseclasses.CollectionView;
import authoring.view.icons.ImageBasedIcon;
import authoring.view.icons.ImageIcon;

/**
 * View component that corresponds with the backend model component -
 * GraphicsCollection. Updates if any changes occur in Graphics Collection via
 * observer/observable.
 * 
 * @author Kevin Li
 * @author Chris Bernt
 *
 */
public class ImagesView extends CollectionView implements Observer {
	private static final double VIEW_HEIGHT_RATIO = .65;
	private static final double VIEW_WIDTH_RATIO = 0.2;
	private VBox myVbox = new VBox();
	private File myGameLocation;

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

	public void setDragOver(GameHandler handler) {
		this.setOnDragOver(handler);
	}

	public void setDragDrop(GameHandler handler) {
		this.setOnDragDropped(handler);
	}

	public void addImage(String s) {
		ImageBasedIcon graphic = new ImageIcon(s, myGameLocation, myIconEvents);
		myVbox.getChildren().add(graphic);
	}

}
