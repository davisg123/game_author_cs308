package gamePlayer.view;

import java.util.Iterator;

import engine.conditions.ButtonCondition;
import engine.conditions.Condition;
import authoring.model.collections.ConditionsCollection;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class KeyboardView {

	private static final String[] KEYS = {"`", "1", "2", "3", "4", "5",
		"6", "7", "8", "9", "0", "-", "=", "<----", "tab", "Q", "W",
		"E", "R", "T", "Y", "U", "I", "O", "P", "[", "]", "\\", "caps lock",
		"A", "S", "D", "F", "G", "H", "J", "K", "L", ";", "'", "enter", "", "shift", 
		"Z", "X", "C", "V", "B", "N", "M", ",", ".", "/", "shift", "up", "",
		"", "", "", "", "", "", "spacebar", "", "", "", "", "down", "left", "right"};

	private static final double WIDTH = 950;
	private static final double HEIGHT = 300;
	private GridPane myGrid;
	private Stage myStage;
	private ConditionsCollection myButtonConditions;
	private ComboBox<String> myFunctionComboBox;
	
	public KeyboardView(ConditionsCollection buttonConditions) {
		myStage = new Stage();
		myStage.setTitle("Vooga Salad Bits Please Keyboard Mapping Utility");
		myGrid = new GridPane();
		Scene myScene = new Scene(myGrid, WIDTH, HEIGHT);
//		myScene.getStylesheets().add(getClass().getResource("layoutstyles.css").toExternalForm());
		myStage.setScene(myScene);
		myButtonConditions = buttonConditions;
		myFunctionComboBox = comboBoxForButton();
	}
	
	public void buildKeyboard() {
		int num = 0;
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 14; j++)
			{
				num = buildButton(num, i, j);
			}
		}
		myStage.show();
	}

	private int buildButton(int num, int i, int j) {
		StackPane sp = new StackPane();
		Button button = new Button(KEYS[num]);
		button.setPrefSize(70, 70);
		button.setDisable(KEYS[num] == "");
		button.setOnAction((event) -> {
			new KeyMapForm(button.getText(), myFunctionComboBox);
		});
		sp.getChildren().add(button);
		myGrid.add(sp, j, i);
		num++;
		return num;
	}
	
	private ComboBox<String> comboBoxForButton() {
		ComboBox<String> functionCombos = new ComboBox<String>();
		for (Iterator<Condition> conditionIterator = myButtonConditions.iterator(); conditionIterator.hasNext();) {
			ButtonCondition condition = (ButtonCondition) conditionIterator.next();
			functionCombos.getItems().add(condition.getKeyIdentifier());
		}
		return functionCombos;
	}
}
