package authoring.view.graphicsview;

import java.util.ResourceBundle;

import javafx.scene.control.Button;
import authoring.eventhandlers.GameHandler;
import authoring.view.generalcollectionview.CollectionOptions;

/**
 * @author Kevin Li
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Arjun Jain
 */
public class GraphicOptions extends CollectionOptions {
	private Button addGraphicButton;

	public GraphicOptions(ResourceBundle language, double width, double height) {
		super(language, width, height);
		addNewTabButton();
	}

	private void addNewTabButton() {
		addGraphicButton = makeButton(myLanguage.getString("Add_Image"));
		this.getItems().add(addGraphicButton);
	}

	public void setButtonBehavior(GameHandler handler) {
		addGraphicButton.setOnAction(handler);
	}
}
