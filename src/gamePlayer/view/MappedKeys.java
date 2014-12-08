package gamePlayer.view;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.input.KeyCode;

public class MappedKeys {
	
	private static final String[] KEYCODE_VALUES = { "DEAD_GRAVE", "SOFTKEY_1", "SOFTKEY_2", "SOFTKEY_3", "SOFTKEY_4", 
		"SOFTKEY_5", "SOFTKEY_6", "SOFTKEY_7", "SOFTKEY_8", "SOFTKEY_9", "SOFTKEY_0", "MINUS", "EQUALS",
		"BACK_SPACE", "TAB", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "BRACELEFT", "BRACERIGHT", "BACK_SLASH", "CAPS",
		"A", "S", "D", "F", "G", "H", "J", "K", "L", "SEMICOLON", "", "ENTER", "",
		"SHIFT", "Z", "X", "C", "V", "B", "N", "M", "COMMA", "PERIOD",
		"SLASH", "SHIFT", "UP", "", "", "", "", "", "", "", "SPACE", "",
		"", "", "", "DOWN", "LEFT", "RIGHT" };
	
	private static final String[] KEY_GUI_REPRESENTATIONS = { "`", "1", "2", "3", "4", 
		"5", "6", "7", "8", "9", "0", "-", "=", 
		"BACKSPACE", "TAB", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "[", "]", "\\", "CAPS LOCK",
		"A", "S", "D", "F", "G", "H", "J", "K", "L", ";", "", "ENTER", "",
		"SHIFT", "Z", "X", "C", "V", "B", "N", "M", ",", ".",
		"/", "SHIFT", "UP", "", "", "", "", "", "", "", "SPACE", "",
		"", "", "", "DOWN", "LEFT", "RIGHT" };
	
	public MappedKeys() {
		
	}

	public String getKey(int num)
	{
		return KEY_GUI_REPRESENTATIONS[num];
	}
	
	public KeyCode getKeyCode(String key)
	{
		return KeyCode.valueOf(KEYCODE_VALUES[Arrays.asList(KEY_GUI_REPRESENTATIONS).indexOf(key)]);
	}
}
