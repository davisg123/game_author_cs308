package authoring.view.levelview;

import java.util.ResourceBundle;

import authoring.eventhandlers.GameHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToolBar;

public class LevelOptions extends ToolBar {
	private ResourceBundle myLanguage;
	private TabPane myLevels;
	private double myHeight;
	private double myWidth;
	private GameHandler myButtonHandler;
	private GameHandler[] myEvents;
	private Button addLevelButton;

	public LevelOptions(ResourceBundle language, TabPane levels, double width,
			double height) {
		myLanguage = language;
		myLevels = levels;
		myWidth = width;
		myHeight = height;
		addNewTabButton();
	}

	private void addNewTabButton() {
		this.getItems().add(
				makeButton(myLanguage.getString("Add_Level"), myButtonHandler));
	}

	private Button makeButton(String property, GameHandler handler) {
		addLevelButton = new Button();
		addLevelButton.setText(property);
		return addLevelButton;
	}

	public void setButtonBehavior(GameHandler handler) {
		addLevelButton.setOnAction(handler);
	}

	public void setEventHandlers(GameHandler... handlers) {
		myEvents = handlers;
	}

	public SingleLevelView addNewLevel(String ID) {
		Tab tab = new Tab(ID);
		SingleLevelView newView = new SingleLevelView(myWidth, myHeight,
				myEvents);
		tab.setContent(newView);
		myLevels.getTabs().add(tab);
		myLevels.getSelectionModel().select(tab);
		return newView;
	}

}
