package errorsAndExceptions;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This class creates a PopUp message used for displaying error messages to the user.
 * 
 * @author Chris Bernt
 * @author Eli Lichtenberg
 * @author Safkat Islam
 */
public class ErrorPopUp {
	
	private static final int POP_UP_HEIGHT = 200;
	private static final int POP_UP_WIDTH = 500;
	private static final int TEXT_Y_COORD = POP_UP_HEIGHT/2;
	private static final int TEXT_X_COORD = POP_UP_WIDTH/5;
	private static final int BUTTON_Y_COORD = POP_UP_HEIGHT*5/8;
	private static final int BUTTON_X_COORD = POP_UP_WIDTH/2;
	private static final String ERROR_TITLE = "User Error";
	private static final String BUTTON_TEXT = "OK";
	private Group root;
	private Stage popUpStage;
	
	/**
	 * Constructor.
	 */
	public ErrorPopUp() {
		popUpStage = new Stage();
		popUpStage.setTitle(ERROR_TITLE);
		root = new Group();
		Scene scene = new Scene(root, POP_UP_WIDTH, POP_UP_HEIGHT, Color.LIGHTGRAY);
		popUpStage.setScene(scene);
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
		Text errorText = new Text(TEXT_X_COORD, TEXT_Y_COORD, errorMessage);
		root.getChildren().add(errorText);
		
		Button b = new Button();
		b.setText(BUTTON_TEXT);
		b.setLayoutX(BUTTON_X_COORD);
		b.setLayoutY(BUTTON_Y_COORD);
		root.getChildren().add(b);
		b.setOnAction(closePopUp);
		popUpStage.show();
		
//		if(throwException)
//		{
//			throw new VoogaException(errorMessage);
//		}
	}

}