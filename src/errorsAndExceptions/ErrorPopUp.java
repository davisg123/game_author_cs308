package errorsAndExceptions;

import java.io.PrintWriter;
import java.io.StringWriter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This class creates a PopUp message used for displaying error messages to the user.
 * 
 * @author Chris Bernt
 * @author Eli Lichtenberg
 * @author Safkat Islam
 * @author Abhishek Balakrishnan
 */
public class ErrorPopUp {
	
	private static final int POP_UP_HEIGHT = 150;
	private static final int POP_UP_WIDTH = 300;
	private static final int TEXT_Y_COORD = POP_UP_HEIGHT/2;
	private static final int TEXT_X_COORD = POP_UP_WIDTH/4;
	private static final int BUTTON_Y_COORD = POP_UP_HEIGHT*4/8;
	private static final int BUTTON_X_COORD = POP_UP_WIDTH/2;
	private static final String ERROR_TITLE = "User Error";
	private static final String BUTTON_TEXT = "OK";
	private Group root;
	private Stage popUpStage;
	
	private Exception myException;
	
	/**
	 * Constructor.
	 */
	public ErrorPopUp(Exception e) {
		popUpStage = new Stage();
		popUpStage.setTitle(ERROR_TITLE);
		root = new Group();
		Scene scene = new Scene(root, POP_UP_WIDTH, POP_UP_HEIGHT, Color.LIGHTGRAY);
		popUpStage.setScene(scene);
		myException = e;
	}
	
	
	/**
	 * EventHandler to close the PopUp window.
	 */
	private EventHandler<ActionEvent> closePopUp = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent evt){
			popUpStage.close();
		}
	};
	
	/**
	 * Displays the actual PopUp and throws an exception if needed.
	 * 
	 * @param errorMessage The message to be displayed.
	 * @param throwException Whether an exception needed to be thrown.
	 * @throws SLogoException The type of exception to throw.
	 */
	public void display(String errorMessage, boolean throwException) throws VoogaException{
		root.getChildren().clear();
		VBox box = new VBox();
		root.getChildren().add(box);
		Text errorText = new Text(TEXT_X_COORD, TEXT_Y_COORD, errorMessage);
		box.getChildren().add(errorText);
		
		Button b = new Button();
		b.setText(BUTTON_TEXT);
		b.setLayoutX(BUTTON_X_COORD);
		b.setLayoutY(BUTTON_Y_COORD);
		root.getChildren().add(b);
		b.setOnAction(closePopUp);
		
		createErrorButton();
				
		popUpStage.show();
		
		if(throwException)
		{
			throw new VoogaException(errorMessage);
		}
	}

	private void createErrorButton() {
		// TODO Auto-generated method stub
		Button b = new Button();
		b.setText("View Error Trace");
		b.setLayoutX(BUTTON_X_COORD-40);
		b.setLayoutY(BUTTON_Y_COORD+40);
		b.setOnAction(handle -> viewErrorTrace());
		root.getChildren().add(b);
	}
	
	private void viewErrorTrace() {
		Stage errorTraceStage = new Stage();
		errorTraceStage.setX(popUpStage.getX()*1.75);
		errorTraceStage.setY(popUpStage.getY()*.75);
		VBox errorBox = new VBox();
		ScrollPane sp = new ScrollPane();
		Label errorTrace = new Label(getStackTrace());
		sp.setContent(errorTrace);
		errorBox.getChildren().add(sp);
		errorBox.setVgrow(sp, Priority.ALWAYS);
		Scene scene = new Scene(errorBox, POP_UP_WIDTH, POP_UP_HEIGHT*3, Color.LIGHTGRAY);
		errorTraceStage.setScene(scene);
		errorTraceStage.show();
	}

	private String getStackTrace() {
		// TODO Auto-generated method stub
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		myException.printStackTrace(pw);
		return sw.toString();
	}

}