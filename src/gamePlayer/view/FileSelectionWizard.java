package gamePlayer.view;

import java.io.File;

import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * 
 * @author Abhishek B
 *
 */
public class FileSelectionWizard {

	private Stage myDirectoryStage;

	public File selectFile() {
		myDirectoryStage = new Stage();
		DirectoryChooser directoryChooser = new DirectoryChooser();
		directoryChooser.setTitle("Open Resource File");
		//directoryChooser.getExtensionFilters().addAll(
		//		new FileChooser.ExtensionFilter("JSON", "*.json"));
		//return directoryChooser.showDialog(myDirectoryStage).getName();
		File f = directoryChooser.showDialog(myDirectoryStage);
		return f;
	}

}
