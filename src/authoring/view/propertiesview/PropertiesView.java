package authoring.view.propertiesview;

import java.util.ResourceBundle;

import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import authoring.view.baseclasses.ScrollView;
import authoring.view.graphicsview.Graphic;

public class PropertiesView extends ScrollView{

	
	private static final double VIEW_HEIGHT_RATIO = .95;
	private static final double VIEW_WIDTH_RATIO = 0.2;
	private VBox myContents = new VBox();	
	
	
	
	public PropertiesView(ResourceBundle language, double width, double height) {
		super(language, width, height);
		setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
		this.setContent(myContents);
	}
	
	public void fillContents(Graphic g){
		myContents.getChildren().clear();
		myContents.getChildren().add(new GameObejctsProperties(g));
	}
	
}
