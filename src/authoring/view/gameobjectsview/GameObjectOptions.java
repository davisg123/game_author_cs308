package authoring.view.gameobjectsview;

import java.util.ResourceBundle;

import javafx.scene.control.Button;
import authoring.eventhandlers.GameHandler;
import authoring.view.generalcollectionview.CollectionOptions;

public class GameObjectOptions extends CollectionOptions{

	private Button addObjectButton;

	public GameObjectOptions(ResourceBundle language, double width, double height) {
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
