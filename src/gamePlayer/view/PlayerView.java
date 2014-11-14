package gamePlayer.view;

import gamePlayer.model.PlayerModel;
import java.io.IOException;
import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PlayerView {

	private PlayerModel myPlayerModel;
	private Stage myStage;
	private Scene myScene;
	private BorderPane myPane; 
	private VBox myCanvasVBox;
	private GameCanvas myCanvas;
	
	public PlayerView(PlayerModel playerModel) {
		myPlayerModel = playerModel;
		myStage = new Stage();
		myPane = new BorderPane();
		myPane.setBackground(new Background(
				new BackgroundFill(Color.WHITE, new CornerRadii(0), new Insets(0))));
		myScene = new Scene(myPane, Main.SIZE.width, Main.SIZE.height);
		myStage.setTitle("MY PLAYER VIEW");
		myStage.setScene(myScene);
		myStage.show();
	}
	
	public void initialize() throws IOException{
		myPane.getChildren().add(FXMLLoader.load(getClass().getResource("RootLayout.fxml")));
		initializeGUIComponents();
		initializeGUIElements();
	}
	
	private void initializeGUIComponents() {
		myCanvas = new GameCanvas();
	}
	
	private void initializeGUIElements(){
		VBox myCanvasVBox = (VBox) myScene.lookup("#canvasVBox");
		myCanvasVBox.getChildren().add(myCanvas.getNode());
	}	
	
}
