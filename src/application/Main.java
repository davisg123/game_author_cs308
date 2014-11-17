package application;

import java.awt.Dimension;
import authoring.view.AuthoringScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

	public static final Dimension SIZE = new Dimension(1300, 800);
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		SplashScreen screen = new SplashScreen();
		screen.show();
		//SplashScreen screen = new SplashScreen();
		//Scene scene = screen.initialize();
		//primaryStage.setScene(scene);
		//primaryStage.show(); 
//		AuthoringScene view = new AuthoringScene(primaryStage);
		
		
	}
	
	
	public static void main(String[] args){
		launch(args);
	}
	

}
