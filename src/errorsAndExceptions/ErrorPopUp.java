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
	
	private static final int MAX_BUTTON_WIDTH = 250;
	private static final int POP_UP_HEIGHT = 200;
	private static final int POP_UP_WIDTH = 300;
	private static final int TEXT_Y_COORD = POP_UP_HEIGHT/2;
	private static final int TEXT_X_COORD = POP_UP_WIDTH/4;
	private static final int BUTTON_Y_COORD = POP_UP_HEIGHT*4/8;
	private static final int BUTTON_X_COORD = POP_UP_WIDTH/2;
	private static final String ERROR_TITLE = "User Error";
	private static final String BUTTON_TEXT = "OK";
	private VBox root;
	private Stage popUpStage;
	private Scene myScene;
	
	private Exception myException;
	
	/**
	 * Constructor without an exception.
	 */
	public ErrorPopUp() {
		popUpStage = new Stage();
		popUpStage.setTitle(ERROR_TITLE);
		root = new VBox();
		myScene = new Scene(root, POP_UP_WIDTH, POP_UP_HEIGHT, Color.valueOf("#00008b"));
		myScene.getStylesheets().add(getClass().getResource("ErrorStyle.css").toExternalForm());
		popUpStage.setScene(myScene);
	}
	
	/**
	 * Constructor with an exception.
	 */
	public ErrorPopUp(Exception e) {
		this();
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
	
	private EventHandler<ActionEvent> viewErrorTrace = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent evt) {
			Stage errorTraceStage = new Stage();
			VBox errorBox = new VBox();
			ScrollPane sp = new ScrollPane();
			Label errorTrace = new Label(getStackTrace());
			errorTrace.setId("error");
			sp.setContent(errorTrace);
			errorBox.getChildren().add(sp);
			errorBox.setVgrow(sp, Priority.ALWAYS);
			Scene scene = new Scene(errorBox, POP_UP_WIDTH*2, POP_UP_HEIGHT*3, Color.LIGHTGRAY);
			scene.getStylesheets().add(getClass().getResource("ErrorStyle.css").toExternalForm());
			errorTraceStage.setScene(scene);
			errorTraceStage.centerOnScreen();
			errorTraceStage.show();
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
//		VBox box = new VBox();
		root.getStyleClass().add("vbox");
		Text errorText = new Text(errorMessage);
		errorText.setId("text");
		
		root.getChildren().add(errorText);
		Button okButton = createButton(root, "OK", BUTTON_X_COORD, BUTTON_Y_COORD, closePopUp);
		root.getChildren().add(okButton);
		if(myException != null) {
		Button viewButton = createButton(root, "View Error Trace", BUTTON_X_COORD-40, BUTTON_Y_COORD+40, viewErrorTrace);
		root.getChildren().add(viewButton);
		double buttonWidth = viewButton.getWidth();
		//get width of button so can send to chooseStageWidth method
		root.autosize();
//		root.getChildren().add(box);
		popUpStage.centerOnScreen();
		double newStageWidth = chooseStageWidth(buttonWidth);
		popUpStage.setWidth(newStageWidth);
		//popUpStage.setWidth(2*textWidth);
		}
		popUpStage.show();
		
		if(throwException)
		{
			throw new VoogaException(errorMessage);
		}
	}

	private double chooseStageWidth(double buttonWidth) {
		// TODO Auto-generated method stub
		return Math.max(2*root.getWidth(), MAX_BUTTON_WIDTH);
	}

	private Button createButton(VBox vbox, String message, double x, double y, EventHandler<ActionEvent> event) {
		// TODO Auto-generated method stub
		Button b = new Button();
		b.setText(message);
		b.setLayoutX(x);
		b.setLayoutY(y);
		b.setOnAction(event);
		b.setId("buttons");
		return b;
	}

	private String getStackTrace() {
		// TODO Auto-generated method stub
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		myException.printStackTrace(pw);
		return sw.toString();
	}

}