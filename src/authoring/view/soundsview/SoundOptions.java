package authoring.view.soundsview;

import java.util.ResourceBundle;

import javafx.scene.control.Button;
import authoring.eventhandlers.GameHandler;
import authoring.view.generalcollectionview.CollectionOptions;

public class SoundOptions extends CollectionOptions {
	private Button addSoundButton;

	public SoundOptions(ResourceBundle language, double width, double height) {
		super(language, width, height);
		addNewSoundButton();
	}

	private void addNewSoundButton() {
		addSoundButton = makeButton(myLanguage.getString("Add_Sound"));
		this.getItems().add(addSoundButton);
	}

	public void setButtonBehavior(GameHandler handler) {
		addSoundButton.setOnAction(handler);

	}
}
