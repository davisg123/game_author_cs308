package application;

import java.awt.Dimension;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

	public static final Dimension SIZE = new Dimension(1300, 800);
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		SplashScreen screen = new SplashScreen();
		screen.show();

	}
	
	
	public static void main(String[] args){
		launch(args);
	}
	

}
