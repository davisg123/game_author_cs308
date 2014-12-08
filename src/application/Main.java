package application;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 
 * @author Abhishek B
 *
 */
public class Main extends Application{

	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		SplashScreen screen = new SplashScreen();
		screen.show();
	}
	
	
	public static void main(String[] args){
		launch(args);
	}
	

}
