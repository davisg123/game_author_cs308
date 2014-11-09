package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		SplashScreen screen = new SplashScreen();
		Scene scene = screen.initialize();
		primaryStage.setScene(scene);
		primaryStage.show(); 
		
	}
	
	
	public static void main(String[] args){
		launch(args);
	}
	

}
