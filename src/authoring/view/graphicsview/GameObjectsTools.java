package authoring.view.graphicsview;

import java.util.ResourceBundle;

import javafx.scene.control.Button;
import authoring.eventhandlers.GameHandler;
import authoring.view.generalcollectionview.CollectionsTool;

public class GameObjectsTools extends CollectionsTool{

	private Button addObjectButton;

	public GameObjectsTools(ResourceBundle language, double width, double height) {
		super(language, width, height);
		addNewTabButton();
	}

	private void addNewTabButton() {
		addObjectButton = makeButton(myLanguage.getString("Add_Object"));
		this.getItems().add(addObjectButton);
	}

	public void setButtonBehavior(GameHandler handler) {
		addObjectButton.setOnAction(handler);
	}
	
	
}
