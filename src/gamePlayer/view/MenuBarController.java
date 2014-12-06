package gamePlayer.view;

import gamePlayer.model.PlayerModel;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;

public class MenuBarController implements Initializable{

	private PlayerModel myPlayerModel;

	@FXML
	private Menu gameSelector;
	
	@FXML
	private Menu gameOptions;
	
	@FXML
	private Menu gamePreferences;

	public void setModel(PlayerModel model){
		myPlayerModel=model;
	}
	
	@FXML
	private void goHome(final ActionEvent event){
		myPlayerModel.goHome();
	}
	
	@FXML
	private void loadGameFile(final ActionEvent event){
		myPlayerModel.loadGameFile();
		gameSelector.setDisable(true);
		gameOptions.setDisable(false);
	}
	
	@FXML 
	private void exitFromGame(final ActionEvent event){
		myPlayerModel.exitFromGame();
		gameOptions.setDisable(true);
		gamePreferences.setDisable(true);
	}
	
	@FXML
	private void loadFromSave(final ActionEvent event) throws CloneNotSupportedException{
		myPlayerModel.loadProgressFile();
		gameSelector.setDisable(true);
		gameOptions.setDisable(false);
		gamePreferences.setDisable(false);
	}
	
	@FXML
	private void newGame(final ActionEvent event){
		myPlayerModel.newGame();
		gameSelector.setDisable(true);
		gameOptions.setDisable(false);
		gamePreferences.setDisable(false);
	}
	
	@FXML
	private void saveGame(final ActionEvent event){
		myPlayerModel.saveGame();
	}
		
	@FXML
	private void quitGame(final ActionEvent event){
		myPlayerModel.quitGame();
		gameSelector.setDisable(false);
		gameOptions.setDisable(true);
		gamePreferences.setDisable(true);
	}

	@FXML
	private void pauseGame(final ActionEvent event){
		myPlayerModel.pauseGame();
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
//		menuBar.setFocusTraversable(true);	
	}
	
	
	
	
}