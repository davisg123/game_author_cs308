package authoring.view.soundsview;

import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import authoring.view.baseclasses.ScrollView;

/**
 * View component that corresponds with backend model data - SoundCollection.
 * Updates via observer whenever a change occurs in SoundCollection.
 * 
 * @author Kevin Li
 *
 */
public class SoundsView extends ScrollView implements Observer {
	private static final double VIEW_HEIGHT_RATIO = .65;
	private static final double VIEW_WIDTH_RATIO = 0.2;

	
	private VBox myContents = new VBox();
	
	
	public SoundsView(ResourceBundle language, double width, double height) {
		super(language, width, height);
		setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
		this.setContent(myContents);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}
	
	
	
	public void addImage(String s){
		myContents.getChildren().add(new Text(s));
	}

}
