package authoring.view.propertiesview;

import static authoring.view.icons.LevelIcon.DEFAULT_FONT_SIZE;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import authoring.eventhandlers.GameHandler;
import authoring.view.icons.LevelIcon;
import engine.gameObject.Identifier;

/**
 * @author Kevin Li
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Arjun Jain
 */
public class LevelProperties extends Properties {

	private GameHandler[] myConditionHandlers;

	public LevelProperties(Object o, GameHandler... handlers) {
		myConditionHandlers = handlers;
		initializeProperties(o);
	}

	@Override
	public void initializeProperties(Object o) {
		LevelIcon graphic = (LevelIcon) o;

		this.getChildren().clear();

		myMap.put("name", new PropertyTextField("Level: ", graphic.getName()));
		myMap.put("background image", new PropertyTextField(
				"Background Image: ", graphic.getLevel().getBackgroundImage()));
		myMap.put("background music", new PropertyTextField(
				"Background Music: ", graphic.getLevel().getBackgroundMusic()));

		myMap.put("is first level", new BooleanField("First level: ", graphic
				.getLevel().isStartLevel()));

		super.addMapToView();

		Button addCond = new Button("Add Condition");
		addCond.setOnAction(myConditionHandlers[0]);
		this.getChildren().add(addCond);

		Button delCond = new Button("Delete Condition");
		delCond.setOnAction(myConditionHandlers[1]);
		this.getChildren().add(delCond);

		for (Identifier i : graphic.getLevel().getConditionIdentifiers()) {
			Text textID = new Text(i.getUniqueId());
			textID.setFont(new Font(DEFAULT_FONT_SIZE));
			this.getChildren().add(textID);
		}

	}

}