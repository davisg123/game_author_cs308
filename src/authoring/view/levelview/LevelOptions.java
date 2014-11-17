package authoring.view.levelview;

import java.util.ResourceBundle;

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

	public LevelOptions(ResourceBundle language, TabPane levels, double width,
			double height) {
		myLanguage = language;
		myLevels = levels;
		myWidth = width;
		myHeight = height;
		addNewTabButton();
		addTab();
	}

	private void addNewTabButton() {
		this.getItems().add(
				makeButton(myLanguage.getString("Add_Level"),
						handle -> addTab()));
	}

	private Button makeButton(String property, EventHandler<ActionEvent> handler) {
		Button result = new Button();
		result.setText(property);
		result.setOnAction(handler);
		return result;
	}

	public void addTab() {
		Tab tab = new Tab(myLanguage.getString("New_Level"));
		SingleLevelView newView = new SingleLevelView(myWidth, myHeight);
		tab.setContent(newView);
		myLevels.getTabs().add(tab);
		myLevels.getSelectionModel().select(tab);
	}
}
