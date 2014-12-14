package authoring.view.icons;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import authoring.eventhandlers.GameHandler;
import authoring.view.propertiesview.Properties;
import engine.level.Level;

/**
 * @author Kevin Li
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Arjun Jain
 */
public abstract class TextIcon extends BaseIcon implements IPropertiesMaker {

	public static final int DEFAULT_FONT_SIZE = 20;

	public TextIcon(String s, GameHandler... events) {
		super(s, events);
		setupGraphic();
	}

	public void setupGraphic() {
		Text text = new Text(myLabel);
		text.setFont(new Font(DEFAULT_FONT_SIZE));
		this.getChildren().add(text);
		for (GameHandler g : myOnClick) {
			this.addEventFilter(g.getEventType(), g);
		}

	}

	@Override
	public abstract Properties makeProperties();

}
