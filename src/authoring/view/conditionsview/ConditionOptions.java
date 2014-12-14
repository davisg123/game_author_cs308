package authoring.view.conditionsview;

import java.util.ResourceBundle;

import javafx.scene.control.Button;
import authoring.eventhandlers.GameHandler;
import authoring.view.generalcollectionview.CollectionOptions;

public class ConditionOptions extends CollectionOptions {
	private Button addConditionButton;
	private Button deleteConditionButton;

	public ConditionOptions(ResourceBundle language, double width, double height) {
		super(language, width, height);
		addButtons();
	}

	private void addButtons() {
		addConditionButton = makeButton(myLanguage.getString("Add_Condition"));
		this.getItems().add(addConditionButton);
		deleteConditionButton = makeButton(myLanguage.getString("Delete_Condition"));
		this.getItems().add(deleteConditionButton);
	}

	public void setAddConditionButtonBehavior(GameHandler handler) {
		addConditionButton.setOnAction(handler);
	}
	public void setDeleteConditionButtonBehavior(GameHandler handler){
		deleteConditionButton.setOnAction(handler);
	}
}
