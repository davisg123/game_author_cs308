package engine;

import java.util.List;
import javafx.scene.Group;
import engine.conditions.*;
import engine.render.SpriteRenderer;
import engine.sprite.*;

/**
 * 
 * @author Davis
 *
 */

public class GameManager {
	private List<Condition> myGameConditions;
	private List<Sprite> myGameSprites;
	private SpriteRenderer mySpriteRenderer;
	private Group myRootGroup;

	public GameManager(List<Condition> myGameConditions,
			List<Sprite> myGameSprites, Group myRootGroup) {
		super();
		this.myGameConditions = myGameConditions;
		this.myGameSprites = myGameSprites;
		this.myRootGroup = myRootGroup;
		renderSprites();
		addFramesToGroup();
	}

	private void renderSprites() {
		SpriteRenderer mySpriteRenderer = new SpriteRenderer();
		mySpriteRenderer.renderSprites(myGameSprites);
	}

	private void addFramesToGroup() {
		for (Sprite s : myGameSprites) {
			myRootGroup.getChildren().add(s.getNode());
		}
	}

	/**
	 * run updates on every sprite and every condition
	 */
	public void processFrame() {
		// System.out.println("frame");
	}
}
