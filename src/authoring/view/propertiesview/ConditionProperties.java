package authoring.view.propertiesview;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import authoring.eventhandlers.AddActionHandler;
import authoring.eventhandlers.GameHandler;
import authoring.view.icons.ConditionIcon;
import engine.actions.Action;
import engine.conditions.Condition;

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

		HBox imageField = new HBox();
		imageField.getChildren().add(new Text("Name: "));
		imageField.getChildren().add(new TextField(icon.getName()));
		this.getChildren().add(imageField);

		Button addAction = new Button();
		addAction.setText("Add Action");
		((AddActionHandler)myHandler).setCondition(myCondition);
		addAction.setOnAction(myHandler);
		this.getChildren().add(addAction);
		
		for (Action a : myCondition.getActions()){
			Text t = new Text(a.getClass().toString());
			this.getChildren().add(t);
		}
	}

}
