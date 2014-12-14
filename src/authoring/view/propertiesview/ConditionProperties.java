package authoring.view.propertiesview;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import authoring.eventhandlers.AddActionHandler;
import authoring.eventhandlers.GameHandler;
import authoring.view.icons.ConditionIcon;
import engine.actions.Action;
import engine.conditions.Condition;

/**
 * @author Kevin Li
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Arjun Jain
 */
public class ConditionProperties extends Properties {

	private GameHandler myHandler;
	private Condition myCondition;

	public ConditionProperties(Object o, GameHandler gh) {
		myHandler = gh;
		myCondition = ((ConditionIcon) o).getCondition();
		initializeProperties(o);
	}

	@Override
	public void initializeProperties(Object o) {
		ConditionIcon icon = (ConditionIcon) o;

		this.getChildren().clear();

		VBox imageField = new VBox();
		PropertyTextField nameField = new PropertyTextField("Name: ",
				icon.getName());
		nameField.setDisable(true);
		imageField.getChildren().add(nameField);
		this.getChildren().add(imageField);

		for (String s : icon.getCondition().getInputMap().keySet()) {
			PropertyTextField t = new PropertyTextField(
					s.split(" ")[s.split(" ").length - 1] + ": ", icon
							.getCondition().getInputMap().get(s));
			t.setDisable(true);
			imageField.getChildren().add(t);
		}

		Button addAction = new Button();
		addAction.setText("Add Action");
		((AddActionHandler) myHandler).setCondition(myCondition);
		addAction.setOnAction(myHandler);
		this.getChildren().add(addAction);

		for (Action a : myCondition.getActions()) {
			Text t = new Text(a.getClass().toString());
			this.getChildren().add(t);
		}
	}

}
