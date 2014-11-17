package gamePlayer.view;

import gamePlayer.model.PlayerModel;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;

public class MenuBarController implements Initializable{

	private PlayerModel myPlayerModel;
	
	@FXML
	private MenuBar menuBar;

	public void setModel(PlayerModel model){
		myPlayerModel=model;
	}
	
	@FXML
	private void load(final ActionEvent event) throws CloneNotSupportedException{
		myPlayerModel.loadGame();
	}
	
	@FXML
	private void newGame(final ActionEvent event){
		myPlayerModel.newGame();
	}
	
	@FXML
	private void save(final ActionEvent event){
		myPlayerModel.saveGame();
	}
	
	@FXML
	private void pause(final ActionEvent event){
	}
	
	@FXML
	private void quit(final ActionEvent event){
		myPlayerModel.quitGame();
	}

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
//		menuBar.setFocusTraversable(true);	
	}
	
	
	
	
}
