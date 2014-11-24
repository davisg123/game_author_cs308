package authoring.view.levelview;

import java.util.ResourceBundle;

import authoring.eventhandlers.GameHandler;
import authoring.view.generalcollectionview.CollectionsTool;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToolBar;

public class LevelOptions extends CollectionsTool {
	private Button addLevelButton;

	public LevelOptions(ResourceBundle language, double width, double height) {
		super(language, width, height);
		addNewTabButton();
	}

	private void addNewTabButton() {
		addLevelButton = makeButton(myLanguage.getString("Add_Level"));
		this.getItems().add(addLevelButton);
	}

	public void setButtonBehavior(GameHandler handler) {
		addLevelButton.setOnAction(handler);
	}
}
