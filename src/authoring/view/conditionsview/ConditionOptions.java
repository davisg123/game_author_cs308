package authoring.view.conditionsview;

import java.util.ResourceBundle;

import javafx.scene.control.Button;
import authoring.eventhandlers.GameHandler;
import authoring.view.generalcollectionview.CollectionOptions;

public class ConditionOptions extends CollectionOptions {
	private Button addConditionButton;

	public ConditionOptions(ResourceBundle language, double width, double height) {
		super(language, width, height);
		addNewButton();
	}

	private void addNewButton() {
		addConditionButton = makeButton(myLanguage.getString("Add_Condition"));
		this.getItems().add(addConditionButton);
	}

	public void setButtonBehavior(GameHandler handler) {
		addConditionButton.setOnAction(handler);
	}
}
