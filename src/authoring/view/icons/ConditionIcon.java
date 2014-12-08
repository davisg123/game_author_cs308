package authoring.view.icons;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import authoring.eventhandlers.GameHandler;
import engine.conditions.Condition;
import static authoring.view.icons.LevelIcon.DEFAULT_FONT_SIZE;

public class ConditionIcon extends BaseIcon{

	private Condition myCondition;
	private GameHandler[] myEvents;
	
	public ConditionIcon(String label, Condition condition, GameHandler[] handler) {
		super(label, handler);
		myCondition = condition;
		myEvents = handler;
		setupGraphic();
	}
	
	//SAME AS LEVEL ICON, REFACTOR
	public void setupGraphic(){
		Text text = new Text(myLabel);
		text.setFont(new Font(DEFAULT_FONT_SIZE));
		this.getChildren().add(text);
		for (GameHandler g : myOnClick) {
			this.addEventFilter(g.getEventType(), g);
		}
	}

	public Condition getCondition(){
		return myCondition;
	}
	
}
