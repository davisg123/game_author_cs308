package gamePlayer.view;

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

public class RibbonOptionsTab extends RibbonMenuTab {

	private Tab myRibbonTab;
	private HBox myContainer;
	private Button myNewButton;
	private Button myLoadButton;
	private Button mySaveButton;
	private Button myPauseButton;
	private Button myQuitButton;

	public RibbonOptionsTab(String ribbonTabTitle) {
		super(ribbonTabTitle);

		myRibbonTab = new Tab(ribbonTabTitle);
		myNewButton = new Button();
		myLoadButton = new Button();
		mySaveButton = new Button();
		myPauseButton = new Button();
		myQuitButton = new Button();

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

		buildNewButton();
		buildLoadButton();
		buildSaveButton();
		buildPauseButton();
		buildQuitButton();

		myContainer.getChildren().addAll(myNewButton, myLoadButton,
				mySaveButton, myPauseButton, myQuitButton);
		myRibbonTab.setContent(myContainer);
	}

	private void buildNewButton() {
		ImageView imageView = new ImageView(new Image(this.getClass()
				.getResourceAsStream("new_button.png"), 30.0, 30.0, true, true));
		myNewButton.setTooltip(new Tooltip("New Game"));
		myNewButton.setGraphic(imageView);
	}

	private void buildLoadButton() {
		ImageView imageView = new ImageView(
				new Image(this.getClass()
						.getResourceAsStream("load_button.png"), 30.0, 30.0,
						true, true));
		myNewButton.setTooltip(new Tooltip("Load Game"));
		myNewButton.setGraphic(imageView);
	}

	private void buildSaveButton() {
		ImageView imageView = new ImageView(
				new Image(this.getClass()
						.getResourceAsStream("save_button.png"), 30.0, 30.0,
						true, true));
		myNewButton.setTooltip(new Tooltip("Save Game"));
		myNewButton.setGraphic(imageView);
	}

	private void buildPauseButton() {
		ImageView imageView = new ImageView(new Image(this.getClass()
				.getResourceAsStream("pause_button.png"), 30.0, 30.0, true,
				true));
		myPauseButton.setTooltip(new Tooltip("Pause Game"));
		myPauseButton.setGraphic(imageView);
	}

	private void buildQuitButton() {
		ImageView imageView = new ImageView(
				new Image(this.getClass()
						.getResourceAsStream("quit_button.png"), 30.0, 30.0,
						true, true));
		myQuitButton.setTooltip(new Tooltip("Quit Game"));
		myQuitButton.setGraphic(imageView);
	}
}
