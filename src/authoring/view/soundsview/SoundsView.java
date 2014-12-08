package authoring.view.soundsview;

import java.io.File;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.scene.layout.VBox;
import authoring.eventhandlers.GameHandler;
import authoring.view.baseclasses.CollectionView;
import authoring.view.icons.SoundIcon;
import data.Observable;
import data.Observer;

/**
 * View component that corresponds with backend model data - SoundCollection.
 * Updates via observer whenever a change occurs in SoundCollection.
 * 
 * @author Kevin Li
 *
 */
public class SoundsView extends CollectionView implements Observer {
	private static final double VIEW_HEIGHT_RATIO = .65;
	private static final double VIEW_WIDTH_RATIO = 0.2;

	private File myGameLocation;
	private VBox myContents = new VBox();

	public SoundsView(ResourceBundle language, double width, double height,
			File gameLoc) {
		super(language, width, height);
		setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
		myGameLocation = gameLoc;
		this.setContent(myContents);
	}

	private void addSound(String arg) {
		SoundIcon soundIcon = new SoundIcon(myGameLocation, arg, myIconEvents);
		this.getChildren().add(soundIcon);
	}

	public void setDragOver(GameHandler<Event> handler) {
		this.setOnDragOver(handler);
	}

	public void setDragDrop(GameHandler<Event> handler) {
		this.setOnDragDropped(handler);
	}

	@Override
	public void update(Observable o, Object arg) {
		addSound((String) arg);
	}

}
