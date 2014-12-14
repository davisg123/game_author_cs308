package authoring.view.levelview;

import java.util.ResourceBundle;

import authoring.eventhandlers.GameHandler;
import authoring.view.generalcollectionview.CollectionOptions;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToolBar;

public class LevelOptions extends CollectionOptions {
	private Button addLevelButton;
	private Button deleteLevelButton;

	public LevelOptions(ResourceBundle language, double width, double height) {
		super(language, width, height);
		addNewButtons();
	}

	private void addNewButtons() {
		addLevelButton = makeButton(myLanguage.getString("Add_Level"));
		this.getItems().add(addLevelButton);
		deleteLevelButton = makeButton(myLanguage.getString("Delete_Level"));
		this.getItems().add(deleteLevelButton);
	}

	public void setAddLevelButtonBehavior(GameHandler handler) {
		addLevelButton.setOnAction(handler);
	}
	public void setDeleteLevelButtonBehavior(GameHandler handler){
		deleteLevelButton.setOnAction(handler);
	}
}
