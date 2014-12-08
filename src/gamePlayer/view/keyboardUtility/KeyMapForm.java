package gamePlayer.view.keyboardUtility;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KeyMapForm {

	private static final int FORM_HEIGHT = 200;
	private static final int FORM_WIDTH = 300;
	private static final int BUTTON_Y_COORD = FORM_HEIGHT*5/8;
	private static final int BUTTON_X_COORD = FORM_WIDTH/2;
	private static final String BUTTON_TEXT = "Map Key!";
	private Group root;
	private Stage form;
	private ComboBox<String> myComboBox;
	private KeyboardView myKeyboardView;
	private String myKey;
	
	public KeyMapForm(ComboBox<String> comboBox, KeyboardView kv) {
		myComboBox = comboBox;
		myKeyboardView = kv;
	}
	
	public void createKeyMapForm(String key) {
		myKey = key;
		form = new Stage();
		root = new Group();
		Scene scene = new Scene(root, FORM_WIDTH, FORM_HEIGHT, Color.LIGHTGRAY);
		scene.getStylesheets().add(getClass().getResource("form.css").toExternalForm());
		form.setScene(scene);
		VBox formVBox = new VBox();
		formVBox.setPrefSize(FORM_WIDTH, FORM_HEIGHT);
		formVBox.getStyleClass().add("vbox");
		Text t = new Text("This button (" + key + ") now maps to:");
		t.setId("text");
		Button b = new Button();
		b.setId("button");
		b.setText(BUTTON_TEXT);
		b.setLayoutX(BUTTON_X_COORD);
		b.setLayoutY(BUTTON_Y_COORD);
		formVBox.getChildren().addAll(t, myComboBox, b);
		root.getChildren().add(formVBox);
		b.setOnAction(mapKey);
		form.show();
		
//		return myComboBox.getValue();
	}
	
	private EventHandler<ActionEvent> mapKey = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent evt){
			myKeyboardView.setNewKey(myKey, myComboBox.getValue());
			form.close();
		}
	};
	
	
}