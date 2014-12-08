package errorsAndExceptions;

import javafx.application.Application;
import javafx.stage.Stage;

public class ErrorMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Exception e = new Exception("Error: NullPointerException, etc.");
		ErrorPopUp epu = new ErrorPopUp(e);
		epu.display("You have an error.", false);
	}
	
	public static void main(String args[]) {
		launch(args);
	}

}
