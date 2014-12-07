package gamePlayer.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class KeyboardView extends Application {

	public static final String[] keys = {"`", "1", "2", "3", "4", "5",
		"6", "7", "8", "9", "0", "-", "=", "<----", "tab", "Q", "W",
		"E", "R", "T", "Y", "U", "I", "O", "P", "[", "]", "\\", "caps lock",
		"A", "S", "D", "F", "G", "H", "J", "K", "L", ";", "'", "enter", "", "shift", 
		"Z", "X", "C", "V", "B", "N", "M", ",", ".", "/", "shift", "up", "",
		"", "", "", "", "", "", "spacebar", "", "", "", "", "down", "left", "right"};

	private static final double WIDTH = 950;
	private static final double HEIGHT = 300;
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage s) throws Exception {
		Stage myStage = new Stage();
		myStage.setTitle("Vooga Salad Bits Please Keyboard Mapping Utility");
		GridPane myPane = new GridPane();
		Scene myScene = new Scene(myPane, WIDTH, HEIGHT);
//		myScene.getStylesheets().add(getClass().getResource("layoutstyles.css").toExternalForm());
		myStage.setScene(myScene);
		int num = 0;
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 14; j++)
			{
				StackPane sp = new StackPane();
				Button b = new Button(keys[num]);
				b.setPrefSize(70, 70);
				sp.getChildren().add(b);
				myPane.add(sp, j, i);
				num++;				
			}
		}
		myStage.show();
	}

}
