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
	private GameHandler[] myHandlers;

	public LevelOptions(ResourceBundle language, TabPane levels, double width,
			double height, GameHandler ...gameHandlers) {
		myLanguage = language;
		myLevels = levels;
		myWidth = width;
		myHeight = height;
		myHandlers = gameHandlers;
		addNewTabButton();
	}

	private void addNewTabButton() {
		this.getItems().add(
				makeButton(myLanguage.getString("Add_Level"),
						myHandlers));
	}

	private Button makeButton(String property, GameHandler ... handler) {
		Button result = new Button();
		result.setText(property);
		for (GameHandler h : handler){
			result.setOnAction(h);
		}
		return result;
	}

	public SingleLevelView addNewLevel() {
		Tab tab = new Tab(myLanguage.getString("New_Level"));
		SingleLevelView newView = new SingleLevelView(myWidth, myHeight);
		tab.setContent(newView);
		myLevels.getTabs().add(tab);
		myLevels.getSelectionModel().select(tab);
		return newView;
	}
	
}
