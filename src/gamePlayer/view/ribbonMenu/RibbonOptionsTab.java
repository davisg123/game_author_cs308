package gamePlayer.view.ribbonMenu;

import gamePlayer.view.ViewController;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * 
 * @author Abhishek B
 * Inspiration from https://introjava.wordpress.com/2012/04/08/java-fx-2-ribbon-menu/
 */

public class RibbonOptionsTab {
	
	private Tab myTab;
	private Button myNewButton;
	private Button myLoadButton;
	private Button mySaveButton;
	private Button myPauseButton;
	private Button myQuitButton;
	
	public RibbonOptionsTab() {
		myTab = new Tab("Options");
		myNewButton = new Button();
		buildTab();
	}

	private void buildTab() {
		myTab.setClosable(true);
		HBox container = new HBox();
		buildNewButton();
	}
	
	private void buildNewButton() {
		String imagePath = "/ui/common/images/cut.png";
        Image cut = new Image(this.getClass().getResourceAsStream(imagePath),
                16.0, 16.0, true, true);
        ImageView imageView = new ImageView(cut);
		
		myNewButton.setTooltip(new Tooltip("New"));
		myNewButton.setGraphic(imageView);
	}

}
