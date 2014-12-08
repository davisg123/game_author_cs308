package gamePlayer.view;

import gamePlayer.model.PlayerModel;
import gamePlayer.view.keyboardUtility.KeyboardView;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;

/**
 * 
 * @author Shreyas B
 * @author Abhishek B
 *
 */

public class MenuBarController implements Initializable{

	private PlayerModel myPlayerModel;
	private KeyboardView myKeyboard;

	@FXML
	private Tab gameSelector;
	
	@FXML
	private Tab gameOptions;
	
	@FXML
	private Tab gamePreferences;

	public void setModel(PlayerModel model){
		myPlayerModel=model;
	}
	
	public void setKeyboard() {
		myKeyboard = new KeyboardView(myPlayerModel.getButtonConditions());
	}
	
	@FXML
	private void loadGameFile(final ActionEvent event){
		myPlayerModel.loadGameFile();
		gameSelector.setDisable(true);
		gameOptions.setDisable(false);
		gamePreferences.setDisable(false);
	}
	
	@FXML
	private void exitFromGame(final ActionEvent event){
		myPlayerModel.exitFromGame();
		gameOptions.setDisable(true);
		gamePreferences.setDisable(true);
	}
	
	@FXML
	private void fetchGameFromWeb(final ActionEvent event) {
		myPlayerModel.fetchGameFromWeb();
	}
	
	@FXML
	private void saveGameToWeb(final ActionEvent event) {
		myPlayerModel.saveGameToWeb();
	}
	
	@FXML
	private void pauseGame(final ActionEvent event){
		myPlayerModel.pauseGame();
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		menuBar.setFocusTraversable(true);	
	}
	
	@FXML
	private void keyCombos(final ActionEvent event) {
		myPlayerModel.pauseGame();
		myKeyboard.createKeyboardView();
	}
	
}
