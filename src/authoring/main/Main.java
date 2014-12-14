package authoring.main;

import java.util.Locale;

import authoring.view.AuthoringScene;
import javafx.application.Application;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {
	public static final double SCREEN_WIDTH = Screen.getPrimary()
			.getVisualBounds().getWidth();
	public static final double SCREEN_HEIGHT = Screen.getPrimary()
			.getVisualBounds().getHeight();
	private Locale myDefaultLocale = new Locale("en", "US");

	private AuthoringScene myScene;

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setResizable(false);
		myScene = new AuthoringScene(primaryStage, myDefaultLocale,
				SCREEN_WIDTH, SCREEN_HEIGHT);
		primaryStage.setScene(myScene.getScene());
		primaryStage.show();
		myScene.getScene()
				.getStylesheets()
				.add(getClass().getResource("authoringlayout.css")
						.toExternalForm());

	}

	public static void main(String args[]) {
		launch(args);
	}
}
