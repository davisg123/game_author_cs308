package gamePlayer.view;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import data.DataManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * Class that displays names of available progress states and lets user 
 * choose progress state. Hides actual files from user.
 * 
 * @author Eli Lichtenberg
 */
public class ProgressSelector {
	
	File myProgressFolder;
	ObservableList<String> myProgressList;
	ListView<String> myProgressListView;
	String selectedProgressState;
	
	public ProgressSelector(File gameLocation) {
		myProgressFolder = new File(gameLocation, DataManager.PROGRESS_FOLDER_NAME);
		myProgressList = FXCollections.observableArrayList();
		updateProgressList();
		myProgressListView = new ListView<String>(myProgressList);
		addListViewListener();
	}
	
	private void addListViewListener() {
		myProgressListView.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<String>() {
					@Override
					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						selectedProgressState = newValue;
					}
				});
	}

	private void updateProgressList() {
		File[] progressFiles = myProgressFolder.listFiles();
		for(File f : progressFiles) {
			myProgressList.add(f.getName());
		}
		
	}

	public String loadProgressState() {
		updateProgressList();
		Stage progressStage = new Stage();
		progressStage.setTitle("Choose progress state");
		Group root = new Group();
		Scene scene = new Scene(root, 200, 200);
		root.getChildren().add(myProgressListView);
		progressStage.show();
		return selectedProgressState;
	}
	
	public String saveProgressState() {
		updateProgressList();
	}

}
