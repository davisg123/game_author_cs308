package gamePlayer.view;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileSelectionWizard {

	private Stage myFileStage;

	public String selectFile() {
		myFileStage = new Stage();
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		fileChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("JSON", "*.json"));
		return fileChooser.showOpenDialog(myFileStage).getName();
	}

}
