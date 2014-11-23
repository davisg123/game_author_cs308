package authoring.view.graphicsview;

import java.util.ResourceBundle;

import javafx.scene.control.Button;
import authoring.eventhandlers.GameHandler;
import authoring.view.generalcollectionview.CollectionsTool;

public class GraphicsTools extends CollectionsTool {
	private Button addLevelButton;

	public GraphicsTools(ResourceBundle language, double width, double height) {
		super(language, width, height);
		addNewTabButton();
	}

	private void addNewTabButton() {
		addLevelButton = makeButton(myLanguage.getString("Add_Image"));
		this.getItems().add(addLevelButton);
	}

	public void setButtonBehavior(GameHandler handler) {
		addLevelButton.setOnAction(handler);
	}
}
