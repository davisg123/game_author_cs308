package gamePlayer.view;

import java.nio.file.Path;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * 
 * @author Abhishek B
 *
 */
public class FileSelectionWizard {

	private Stage myFileStage;

	public Path selectFile() {
		myFileStage = new Stage();
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		fileChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("JSON", "*.json"));
		return fileChooser.showOpenDialog(myFileStage).toPath();
	}

}
