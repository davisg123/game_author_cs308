package authoring.view;

import java.util.Locale;

import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Class that generates the scene for the authoring environment. The scene
 * contains a MenuBar for changing overall settings and creating new instances
 * of the authoring environment and a TabPane for displaying these views.
 * 
 * @author Kevin Li
 *
 */
public class AuthoringScene {
	private Scene myScene;
	private BorderPane myRoot;
	private TabPane myTabs;
	private MenuView myMenu;

	public AuthoringScene(Stage stage, Locale locale, double width,
			double height) {

		myRoot = new BorderPane();
		myTabs = new TabPane();
		myMenu = new MenuView(myTabs, locale, width, height);
		myRoot.setTop(myMenu);
		myRoot.setCenter(myTabs);
		myScene = new Scene(myRoot, width, height);
	}

	/**
	 * Generates the scene.
	 * 
	 * @return The scene of the program.
	 */
	public Scene getScene() {
		return myScene;
	}

}
