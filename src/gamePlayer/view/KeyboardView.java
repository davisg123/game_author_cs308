package gamePlayer.view;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import authoring.model.collections.ConditionsCollection;
import engine.conditions.ButtonCondition;
import engine.conditions.Condition;

public class KeyboardView {

	private static final int NUM_KEYS_IN_ROW = 14;
	private static final int NUM_KEYS_IN_COLUMN = 5;
	private static final double KEY_WIDTH = 100;
	private static final double KEY_HEIGHT = 100;
	private static final double WIDTH = KEY_WIDTH * NUM_KEYS_IN_ROW;
	private static final double HEIGHT = KEY_HEIGHT * NUM_KEYS_IN_COLUMN;
	private GridPane myGrid;
	private Stage myStage;
	private ConditionsCollection myButtonConditions;
	private Map<KeyCode, String> myButtonConditionsMap;
	private KeyMapForm myKeyMapForm;
	private MappedKeys myMappedKeys;

	public KeyboardView(ConditionsCollection buttonConditions) {
		myButtonConditions = buttonConditions;
		myMappedKeys = new MappedKeys();
		myButtonConditionsMap = new HashMap<KeyCode, String>();
	}

	public void createKeyboardView() {
		myStage = new Stage();
		myStage.setTitle("Vooga Salad Bits Please Keyboard Mapping Utility");
		myGrid = new GridPane();
		Scene myScene = new Scene(myGrid, WIDTH, HEIGHT);
		myScene.getStylesheets().add(getClass().getResource("keyboard.css").toExternalForm());
		myStage.setScene(myScene);
		myKeyMapForm = new KeyMapForm(comboBoxForButton(), this);

		buildKeyboard();
	}

	public void buildKeyboard() {
		int num = 0;
		for(int i = 0; i < NUM_KEYS_IN_COLUMN; i++)
		{
			for(int j = 0; j < NUM_KEYS_IN_ROW; j++)
			{
				num = buildButton(num, i, j);
			}
		}
		myStage.show();
	}

	private int buildButton(int num, int i, int j) {
		StackPane sp = new StackPane();
		String key = this.myMappedKeys.getKey(num);
		Button button = new Button(key);
		button.setId("keyButton");
		button.setPrefSize(KEY_WIDTH, KEY_HEIGHT);
		button.setDisable(key == "");
		button.setOnAction((event) -> {
			myKeyMapForm.createKeyMapForm(key);
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

	public void setNewKey(String button, String keyFunction)
	{
		KeyCode kc = this.myMappedKeys.getKeyCode(button);
		myButtonConditionsMap.put(kc, keyFunction);
		for(Condition c : myButtonConditions) {
			ButtonCondition bc = (ButtonCondition) c;
			List<KeyCode> kcl = bc.getKeyList();
			for(KeyCode k : kcl)
			{
				if(k.equals(kc))
				{
					bc.removeKey(kc);
				}
			}
			if(bc.getKeyIdentifier().equals(keyFunction))
			{
				bc.addKey(kc);
			}
		}
	}
}