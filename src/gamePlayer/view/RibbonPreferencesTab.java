package gamePlayer.view;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * 
 * @author Abhishek B Inspiration from
 *         https://introjava.wordpress.com/2012/04/08/java-fx-2-ribbon-menu/
 */

public class RibbonPreferencesTab extends RibbonMenuTab {

	private Button mySoundButton;
	private Button myKeyCombosButton;

	public RibbonPreferencesTab(String ribbonTabTitle) {
		super(ribbonTabTitle);

		mySoundButton = new Button();
		myKeyCombosButton = new Button();

		buildTab();
	}

	public Tab getTab() {
		return myRibbonTab;
	}

	private void buildTab() {
		myRibbonTab.setClosable(false);
		myContainer = new HBox();
		myContainer.setId("container");
		myContainer.setPrefHeight(40);
		buildReplayButton();

		myRibbonTab.setContent(myContainer);
	}

	private void buildReplayButton() {
		ImageView imageView = new ImageView(new Image(this.getClass()
				.getResourceAsStream("keyboard_button.png"), 30.0, 30.0, true, true));
		myKeyCombosButton.setTooltip(new Tooltip("Keyboard"));
		myKeyCombosButton.setGraphic(imageView);

		myContainer.getChildren().add(myKeyCombosButton);
	}

}
